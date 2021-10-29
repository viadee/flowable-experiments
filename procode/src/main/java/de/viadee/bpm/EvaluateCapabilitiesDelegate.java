package de.viadee.bpm;

import de.viadee.bpm.entity.Person;
import de.viadee.bpm.services.StarWarsApi;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EvaluateCapabilitiesDelegate implements JavaDelegate {

    private final StarWarsApi starWarsApi;

    public EvaluateCapabilitiesDelegate(final StarWarsApi starWarsApi) {
        this.starWarsApi = starWarsApi;
    }

    @Override
    public void execute(final DelegateExecution execution) {

        var speciesName = (String) execution.getVariable("converted_species");
        var species = starWarsApi.getSpecies()
                                 .stream()
                                 .filter(s -> s.getName().equals(speciesName))
                                 .findFirst()
                                 .orElseThrow();

        var personsForSpecies = starWarsApi.getPersonsForSpecies(species);
        int numberOfPersons = starWarsApi.getPersonCountForSpecies(species);

        execution.setVariable("is_capable", numberOfPersons <= personsForSpecies.size());
        execution.setVariable("available_characters", personsForSpecies.stream().map(Person::getName).collect(Collectors.joining(", ")));

    }
}

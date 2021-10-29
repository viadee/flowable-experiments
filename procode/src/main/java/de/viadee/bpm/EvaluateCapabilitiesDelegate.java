package de.viadee.bpm;

import de.viadee.bpm.entity.Person;
import de.viadee.bpm.entity.Species;
import de.viadee.bpm.services.StarWarsApi;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@Component
public class EvaluateCapabilitiesDelegate implements JavaDelegate {

    private final StarWarsApi starWarsApi;

    public EvaluateCapabilitiesDelegate(final StarWarsApi starWarsApi) {
        this.starWarsApi = starWarsApi;
    }

    @Override
    public void execute(final DelegateExecution execution) {

//        var species = (Species) execution.getVariable("my_species");
//
//        int numberOfPersons = starWarsApi.getPersonCountForSpecies(species);
//        var availableCharacters = starWarsApi.getPersonsForSpecies(species)
//                                           .stream()
//                                           .map(Person::getName)
//                                           .collect(joining(", "));
//
//        int numberofguests = (Integer) execution.getVariable("numberofguests");
//
//        execution.setVariable("is_capable", numberOfPersons >= numberofguests);
//        execution.setVariable("available_characters", availableCharacters);

    }
}

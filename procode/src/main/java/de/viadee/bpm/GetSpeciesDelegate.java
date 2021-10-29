package de.viadee.bpm;

import de.viadee.bpm.services.StarWarsApi;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.form.model.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@Component
public class GetSpeciesDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(GetSpeciesDelegate.class);

    private final StarWarsApi starWarsApi;

    public GetSpeciesDelegate(final StarWarsApi starWarsApi) {
        this.starWarsApi = starWarsApi;
    }

    @Override
    public void execute(final DelegateExecution execution) {
        log.info("may the force be with you!");

        var options = starWarsApi.getSpecies()
                                          .stream()
                                          .map(s -> optionWithId(s.getName()))
                                          .collect(Collectors.toList());

        execution.setVariable("extIn_species", options);

    }

    private Option optionWithId(final String name) {
        var opt = new Option(name);
        opt.setId(randomUUID().toString());
        return opt;
    }
}

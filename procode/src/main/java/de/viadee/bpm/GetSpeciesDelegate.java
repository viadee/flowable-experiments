package de.viadee.bpm;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.form.model.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Component
public class GetSpeciesDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(GetSpeciesDelegate.class);


    @Override
    public void execute(final DelegateExecution execution) {
        log.info("may the force be with you!");

        execution.setVariable("extIn_species",
                List.of(optionWithId("Jedi"),
                        optionWithId("Whookie"),
                        optionWithId("Sith")));


    }

    private Option optionWithId(final String name) {
        var opt = new Option(name);
        opt.setId(randomUUID().toString());
        return opt;
    }
}

package de.viadee.bpm;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StarWarsDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(StarWarsDelegate.class);

    @Override
    public void execute(final DelegateExecution execution) {
        log.info("may the force be with you!");
    }
}

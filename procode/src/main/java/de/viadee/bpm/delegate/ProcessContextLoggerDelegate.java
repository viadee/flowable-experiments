package de.viadee.bpm.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProcessContextLoggerDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(ProcessContextLoggerDelegate.class);

    @Override
    public void execute(final DelegateExecution execution) {

        var variables = execution.getVariables()
                                 .entrySet()
                                 .stream()
                                 .sorted(Map.Entry.comparingByKey())
                                 .map(e -> "\tkey: " + e.getKey() + ", val: " + e.getValue())
                                 .collect(Collectors.joining("; \n"));

        log.warn("\nRead all variables from context you must. Yes, hrrmmm.\n{}", variables);
    }

}

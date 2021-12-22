package de.viadee.bpm.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(TestDelegate.class);

    @Override
    public void execute(final DelegateExecution execution) {
        var variables = execution.getVariables();
        var processInstanceId = execution.getProcessInstanceId();

        log.info("[{}] execute test delegate, all variables: {}", processInstanceId, variables);
    }
}

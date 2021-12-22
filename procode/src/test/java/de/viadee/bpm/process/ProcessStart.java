package de.viadee.bpm.process;

import org.flowable.engine.RuntimeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProcessStart {
    private static final Logger log = LoggerFactory.getLogger(ProcessStart.class);
    private static final String PROCESS_DEFINITION_KEY = "test-process";

    @Autowired
    private RuntimeService runtimeService;

    @Test
    void startProcess() {
        var variables = new HashMap<String, Object>();
        variables.put("foo", "Hallo");
        variables.put("bar", "World");

        var processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);

        assertNotNull(processInstance);

        log.info("process started: {}", processInstance);
    }
}

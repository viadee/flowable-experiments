package de.viadee.bpm;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.form.model.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class SelectionConverter implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(SelectionConverter.class);

    @Override
    public void execute(final DelegateExecution execution) {
        var id = (String) execution.getVariable("selected_species");
        List<Option> options = (List<Option>) execution.getVariable("extIn_species");
        var convertedSpecies = options.stream().filter(opt -> id.equals(opt.getId())).findFirst().orElseThrow().getName();
        execution.setVariable("converted_species", convertedSpecies);
        log.info("convertedSpecies: {}", convertedSpecies);
    }
}

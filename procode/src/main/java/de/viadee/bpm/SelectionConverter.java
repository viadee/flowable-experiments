package de.viadee.bpm;

import de.viadee.bpm.entity.Species;
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
        //List<Species> allSpecies = (List<Species>) execution.getVariable("all_species");

        var convertedSpecies = options.stream().filter(opt -> id.equals(opt.getId())).findFirst().orElseThrow().getName();
        //var mySpecies = allSpecies.stream().filter(s -> s.getName().equals(convertedSpecies)).findFirst().orElseThrow();

        execution.setVariable("converted_species", convertedSpecies);
    }
}

package ru.timurrin.crestwave.task.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.timurrin.crestwave.task.config.Config;
import ru.timurrin.crestwave.task.process.Process;

@Controller
public class FormController {
    private static final String SUCCESSFUL_SUBMIT = "Form has been submitted successfully";
    private final Process process;
    private final Config config;

    @Autowired
    public FormController(Config config, Process process) {
        this.config = config;
        this.process = process;
    }

    private FormDto resetForm() {
        FormDto params = new FormDto();
        params.setStart(config.getParamsMinStart());
        params.setCount(config.getParamsMinCount());
        return params;
    }

    private FormParams resetParams() {
        FormParams params = new FormParams();
        params.setMinStart(config.getParamsMinStart());
        params.setMaxStart(config.getParamsMaxStart());
        params.setMinCount(config.getParamsMinCount());
        params.setMaxCount(config.getParamsMaxCount());
        return params;
    }

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("formParams", resetParams());
        model.addAttribute("form", resetForm());
        model.addAttribute("status", "");
        return "form";
    }

    @PostMapping("/")
    public String submit(@ModelAttribute FormDto formDto, Model model) {
        String result = process.run(formDto);
        model.addAttribute("formParams", resetParams());
        model.addAttribute("form", result == null ? resetForm() : formDto);
        model.addAttribute("status", result == null ? SUCCESSFUL_SUBMIT : result);
        return "form";
    }
}

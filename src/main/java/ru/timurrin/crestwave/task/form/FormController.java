package ru.timurrin.crestwave.task.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.timurrin.crestwave.task.process.Process;

@Controller
public class FormController {
    private final Process process;

    @Autowired
    public FormController(Process process) {
        this.process = process;
    }

    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("form", new FormDto());
        return "form";
    }

    @PostMapping("/")
    public String submit(@ModelAttribute FormDto formDto, Model model) {
        process.run(formDto);
        model.addAttribute("form", new FormDto());
        return "form";
    }
}

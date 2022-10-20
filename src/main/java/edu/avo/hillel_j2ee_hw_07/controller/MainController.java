package edu.avo.hillel_j2ee_hw_07.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        String message = "Internet shop";
        model.addAttribute("message", message);
        return "index";
    }

}

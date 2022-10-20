package edu.avo.hillel_j2ee_hw_07.controller;

import edu.avo.hillel_j2ee_hw_07.dto.PersonDTO;
import edu.avo.hillel_j2ee_hw_07.mappers.PersonMapper;
import edu.avo.hillel_j2ee_hw_07.model.Person;
import edu.avo.hillel_j2ee_hw_07.service.PersonService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final PersonService personService;

    public RegistrationController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("personDTO") @Valid PersonDTO personDTO,
                          BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!personDTO.getPassword().equals(personDTO.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Passwords didn't match");
            return "registration";
        }

        try {
            if (personService.loadUserByUsername(PersonMapper.INSTANCE.toPerson(personDTO).getUsername()) != null) {
                model.addAttribute("usernameError",
                        "Username already exists");
                return "registration";
            }

        } catch (UsernameNotFoundException ignored) {

        }

        final Person person = PersonMapper.INSTANCE.toPerson(personDTO);
        personService.createPerson(person);

        return "redirect:/";
    }
}

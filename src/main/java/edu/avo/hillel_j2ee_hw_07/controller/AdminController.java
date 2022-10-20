package edu.avo.hillel_j2ee_hw_07.controller;


import edu.avo.hillel_j2ee_hw_07.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static edu.avo.hillel_j2ee_hw_07.constants.PersonControllerConstants.ErrorMessages.PERSON_NOT_FOUND;
import static edu.avo.hillel_j2ee_hw_07.constants.PersonControllerConstants.InfoMessages.ERROR_MESSAGE;
import static edu.avo.hillel_j2ee_hw_07.constants.PersonControllerConstants.InfoMessages.MESSAGE;

@Slf4j
@Controller
public class AdminController {
    private final PersonService personService;

    public AdminController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/admin/userList")
    public String userList(Model model) {
        model.addAttribute("allUsers", personService.findAll());
        return "admin/userList";
    }


    @GetMapping("/adminDeletePersonById")
    public String deletePersonById(@RequestParam int personId, Model model) {
        if (!personService.deletePerson(personId)) {
            log.error(PERSON_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, PERSON_NOT_FOUND);
        } else {
            model.addAttribute(MESSAGE, String.format("Person %d deleted", personId));
        }
        return "admin/userListResult";
    }


}

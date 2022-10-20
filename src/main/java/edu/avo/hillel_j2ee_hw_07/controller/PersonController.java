package edu.avo.hillel_j2ee_hw_07.controller;

import edu.avo.hillel_j2ee_hw_07.dto.CartDTO;
import edu.avo.hillel_j2ee_hw_07.dto.PersonDTO;
import edu.avo.hillel_j2ee_hw_07.mappers.CartMapper;
import edu.avo.hillel_j2ee_hw_07.mappers.PersonMapper;
import edu.avo.hillel_j2ee_hw_07.model.Person;
import edu.avo.hillel_j2ee_hw_07.service.CartService;
import edu.avo.hillel_j2ee_hw_07.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static edu.avo.hillel_j2ee_hw_07.constants.PersonControllerConstants.ErrorMessages.*;
import static edu.avo.hillel_j2ee_hw_07.constants.PersonControllerConstants.InfoMessages.*;


@Slf4j
@Controller
public class PersonController {

    private final PersonService personService;
    private final CartService cartService;

    public PersonController(PersonService personService, CartService cartService) {
        this.personService = personService;
        this.cartService = cartService;
    }

    @GetMapping("/findAllPersons")
    public String findAllPerson(Model model) {
        List<PersonDTO> personDTOS =
                personService.findAll().stream().map(PersonMapper.INSTANCE::toPersonDTO).collect(Collectors.toList());
        model.addAttribute("personDTOS", personDTOS);
        return "personList";
    }


    @GetMapping("/getCreatePerson")
    public String getCreatePerson(Model model) {
        PersonDTO personDTO = new PersonDTO();
        model.addAttribute(PERSON_DTO, personDTO);
        return "personCreateForm";
    }

    @PostMapping("/postCreatePerson")
    public String postCreatePerson(@ModelAttribute(PERSON_DTO) @Valid PersonDTO personDTO, Model model,
                                   BindingResult bindingResult) {

        String returnForm = "personSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = PERSON_ERROR;
        } else {
            final Person person = PersonMapper.INSTANCE.toPerson(personDTO);
            person.setId(personService.createPerson(person));
            model.addAttribute(PERSON_DTO, PersonMapper.INSTANCE.toPersonDTO(person));
        }
        return returnForm;
    }


    @GetMapping("/deletePersonById")
    public String deleteById(@RequestParam int personId, Model model) {
        String returnForm = PERSON_MESSAGE;
        if (!personService.deletePerson(personId)) {
            log.error(PERSON_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, PERSON_NOT_FOUND);
            returnForm = PERSON_ERROR;
        } else {
            model.addAttribute(MESSAGE, String.format("Person %d deleted", personId));
        }
        return returnForm;
    }


    @GetMapping("/getUpdatePerson")
    public String getUpdatePerson(@RequestParam int personId, Model model) {
        PersonDTO personDTO = PersonMapper.INSTANCE.toPersonDTO(personService.findById(personId));
        model.addAttribute(PERSON_DTO, personDTO);
        return "personUpdateForm";
    }

    @PostMapping("/postUpdatePerson")
    public String putUpdatePerson(@ModelAttribute(PERSON_DTO) @Valid PersonDTO personDTO, Model model,
                                  BindingResult bindingResult) {

        String returnForm = "personSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = PERSON_ERROR;

        } else {

            final Person person = PersonMapper.INSTANCE.toPerson(personDTO);
            if (!personService.updatePerson(person)) {
                log.error(PERSON_NOT_FOUND);
                model.addAttribute(ERROR_MESSAGE, PERSON_NOT_FOUND);
                returnForm = PERSON_ERROR;
            } else {
                model.addAttribute(PERSON_DTO, PersonMapper.INSTANCE.toPersonDTO(person));
            }
        }
        return returnForm;
    }


    @GetMapping("/getPersonCarts")
    public String getPersonCarts(@RequestParam int personId, Model model) {
        List<CartDTO> personCarts =
                personService.findPersonCarts(personId).stream().map(CartMapper.INSTANCE::toCartDTO).collect(Collectors.toList());
        model.addAttribute(PERSON_ID, personId);
        model.addAttribute("personCarts", personCarts);
        return "personCarts";
    }

    @GetMapping("/getPersonCartsAdd")
    public String addPersonCarts(@RequestParam(PERSON_ID) int personId, Model model) {
        List<CartDTO> cartDTOS =
                cartService.findAll().stream().map(CartMapper.INSTANCE::toCartDTO).collect(Collectors.toList());
        model.addAttribute(PERSON_ID, personId);
        model.addAttribute("cartDTOS", cartDTOS);
        return "personCartsAdd";
    }

    @GetMapping("/addPersonCart")
    public String addPersonCart(@RequestParam(PERSON_ID) int personId, @RequestParam("cartId") int cartId,
                                Model model) {
        String returnForm = PERSON_MESSAGE;
        if (!personService.addPersonCart(personId, cartId)) {
            log.error(PERSON_OR_CART_IS_NOT_FOUND);
            model.addAttribute("errorMessage", PERSON_OR_CART_IS_NOT_FOUND);
            returnForm = "personError";

        } else {
            model.addAttribute(MESSAGE, String.format("Cart Id=%d is added", cartId));

        }
        return returnForm;
    }

    @GetMapping("/deletePersonCart")
    public String deletePersonCart(@RequestParam(PERSON_ID) int personId, @RequestParam("cartId") int cartId,
                                   Model model) {
        String returnForm = PERSON_MESSAGE;
        if (!personService.deletePersonCart(personId, cartId)) {
            log.error(PERSON_OR_CART_IS_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, PERSON_OR_CART_IS_NOT_FOUND);
            returnForm = PERSON_ERROR;

        } else {
            model.addAttribute(MESSAGE, String.format("Cart Id=%d is deleted", cartId));

        }
        return returnForm;
    }

}

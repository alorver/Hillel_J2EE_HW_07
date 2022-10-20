package edu.avo.hillel_j2ee_hw_07.controller;

import edu.avo.hillel_j2ee_hw_07.dto.PersonDTO;
import edu.avo.hillel_j2ee_hw_07.dto.ProductDTO;
import edu.avo.hillel_j2ee_hw_07.dto.ShopDTO;
import edu.avo.hillel_j2ee_hw_07.mappers.PersonMapper;
import edu.avo.hillel_j2ee_hw_07.mappers.ProductMapper;
import edu.avo.hillel_j2ee_hw_07.mappers.ShopMapper;
import edu.avo.hillel_j2ee_hw_07.model.Shop;
import edu.avo.hillel_j2ee_hw_07.service.PersonService;
import edu.avo.hillel_j2ee_hw_07.service.ProductService;
import edu.avo.hillel_j2ee_hw_07.service.ShopService;
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

import static edu.avo.hillel_j2ee_hw_07.constants.ShopControllerConstants.ErrorMessages.*;
import static edu.avo.hillel_j2ee_hw_07.constants.ShopControllerConstants.InfoMessages.*;


@Slf4j
@Controller
public class ShopController {

    private final ShopService shopService;
    private final PersonService personService;
    private final ProductService productService;

    public ShopController(ShopService shopService, PersonService personService, ProductService productService) {
        this.shopService = shopService;
        this.personService = personService;
        this.productService = productService;
    }


    @GetMapping("/findAllShops")
    public String findAllShop(Model model) {
        List<ShopDTO> shopDTOS =
                shopService.findAll().stream().map(ShopMapper.INSTANCE::toShopDTO).collect(Collectors.toList());
        model.addAttribute("shopDTOS", shopDTOS);
        return "shopList";
    }


    @GetMapping("/getCreateShop")
    public String getCreateShop(Model model) {
        ShopDTO shopDTO = new ShopDTO();
        model.addAttribute(SHOP_DTO, shopDTO);
        return "shopCreateForm";
    }

    @PostMapping("/postCreateShop")
    public String postCreateShop(@ModelAttribute(SHOP_DTO) @Valid ShopDTO shopDTO, Model model,
                                 BindingResult bindingResult) {

        String returnForm = "shopSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = SHOP_ERROR;
        } else {
            final Shop shop = ShopMapper.INSTANCE.toShop(shopDTO);
            shop.setId(shopService.createShop(shop));
            model.addAttribute(SHOP_DTO, ShopMapper.INSTANCE.toShopDTO(shop));
        }
        return returnForm;
    }


    @GetMapping("/deleteShopById")
    public String deleteById(@RequestParam int shopId, Model model) {
        String returnForm = SHOP_MESSAGE;
        if (!shopService.deleteShop(shopId)) {
            log.error(SHOP_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, SHOP_NOT_FOUND);
            returnForm = SHOP_ERROR;
        } else {
            model.addAttribute(MESSAGE, String.format("Shop %d deleted", shopId));
        }
        return returnForm;
    }


    @GetMapping("/getUpdateShop")
    public String getUpdateShop(@RequestParam int shopId, Model model) {
        ShopDTO shopDTO = ShopMapper.INSTANCE.toShopDTO(shopService.findById(shopId));
        model.addAttribute(SHOP_DTO, shopDTO);
        return "shopUpdateForm";
    }

    @PostMapping("/postUpdateShop")
    public String putUpdateShop(@ModelAttribute(SHOP_DTO) @Valid ShopDTO shopDTO, Model model,
                                BindingResult bindingResult) {

        String returnForm = "shopSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = SHOP_ERROR;

        } else {

            final Shop shop = ShopMapper.INSTANCE.toShop(shopDTO);
            if (!shopService.updateShop(shop)) {
                log.error(SHOP_NOT_FOUND);
                model.addAttribute(ERROR_MESSAGE, SHOP_NOT_FOUND);
                returnForm = SHOP_ERROR;
            } else {
                model.addAttribute(SHOP_DTO, ShopMapper.INSTANCE.toShopDTO(shop));
            }
        }
        return returnForm;
    }



    @GetMapping("/getShopPersons")
    public String getShopPersons(@RequestParam int shopId, Model model) {
        List<PersonDTO> shopPersons =
                shopService.findShopPersons(shopId).stream().map(PersonMapper.INSTANCE::toPersonDTO).collect(Collectors.toList());
        model.addAttribute(SHOP_ID, shopId);
        model.addAttribute("shopPersons", shopPersons);
        return "shopPersons";

    }

    @GetMapping("/getShopPersonsAdd")
    public String addShopPersons(@RequestParam(SHOP_ID) int shopId, Model model) {
        List<PersonDTO> personDTOS =
                personService.findAll().stream().map(PersonMapper.INSTANCE::toPersonDTO).collect(Collectors.toList());
        model.addAttribute(SHOP_ID, shopId);
        model.addAttribute("personDTOS", personDTOS);
        return "shopPersonsAdd";
    }

    @GetMapping("/addShopPerson")
    public String addShopPerson(@RequestParam(SHOP_ID) int shopId, @RequestParam("personId") int personId,
                                Model model) {
        String returnForm = SHOP_MESSAGE;
        if (!shopService.addShopPerson(shopId, personId)) {
            log.error(SHOP_OR_PERSON_IS_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, SHOP_OR_PERSON_IS_NOT_FOUND);
            returnForm = SHOP_ERROR;

        } else {
            model.addAttribute(MESSAGE, String.format("Person Id=%d is added", personId));

        }
        return returnForm;
    }

    @GetMapping("/deleteShopPerson")
    public String deleteShopPerson(@RequestParam(SHOP_ID) int shopId, @RequestParam("personId") int personId,
                                   Model model) {
        String returnForm = SHOP_MESSAGE;
        if (!shopService.deleteShopPerson(shopId, personId)) {
            log.error(SHOP_OR_PERSON_IS_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, SHOP_OR_PERSON_IS_NOT_FOUND);
            returnForm = SHOP_ERROR;

        } else {
            model.addAttribute(MESSAGE, String.format("Person Id=%d is deleted", personId));

        }
        return returnForm;
    }



    @GetMapping("/getShopProducts")
    public String getShopProducts(@RequestParam int shopId, Model model) {
        List<ProductDTO> shopProducts =
                shopService.findShopProducts(shopId).stream().map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
        model.addAttribute(SHOP_ID, shopId);
        model.addAttribute("shopProducts", shopProducts);
        return "shopProducts";
    }

    @GetMapping("/getShopProductsAdd")
    public String addShopProducts(@RequestParam(SHOP_ID) int shopId, Model model) {
        List<ProductDTO> productDTOS =
                productService.findAll().stream().map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
        model.addAttribute(SHOP_ID, shopId);
        model.addAttribute("productDTOS", productDTOS);
        return "shopProductsAdd";
    }

    @GetMapping("/addShopProduct")
    public String addShopProduct(@RequestParam(SHOP_ID) int shopId, @RequestParam("productId") int productId,
                                 Model model) {
        String returnForm = SHOP_MESSAGE;
        if (!shopService.addShopProduct(shopId, productId)) {
            log.error(SHOP_OR_PRODUCT_IS_NOT_FOUND);
            model.addAttribute("errorMessage", SHOP_OR_PRODUCT_IS_NOT_FOUND);
            returnForm = "shopError";

        } else {
            model.addAttribute(MESSAGE, String.format("Product Id=%d is added", productId));

        }
        return returnForm;
    }

    @GetMapping("/deleteShopProduct")
    public String deleteShopProduct(@RequestParam(SHOP_ID) int shopId, @RequestParam("productId") int productId,
                                    Model model) {
        String returnForm = SHOP_MESSAGE;
        if (!shopService.deleteShopProduct(shopId, productId)) {
            log.error(SHOP_OR_PRODUCT_IS_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, SHOP_OR_PRODUCT_IS_NOT_FOUND);
            returnForm = SHOP_ERROR;

        } else {
            model.addAttribute(MESSAGE, String.format("Product Id=%d is deleted", productId));

        }
        return returnForm;
    }


}

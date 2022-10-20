package edu.avo.hillel_j2ee_hw_07.controller;

import edu.avo.hillel_j2ee_hw_07.dto.CartDTO;
import edu.avo.hillel_j2ee_hw_07.dto.ProductDTO;
import edu.avo.hillel_j2ee_hw_07.mappers.CartMapper;
import edu.avo.hillel_j2ee_hw_07.mappers.ProductMapper;
import edu.avo.hillel_j2ee_hw_07.model.Cart;
import edu.avo.hillel_j2ee_hw_07.service.CartService;
import edu.avo.hillel_j2ee_hw_07.service.ProductService;
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

import static edu.avo.hillel_j2ee_hw_07.constants.CartControllerConstants.ErrorMessages.*;
import static edu.avo.hillel_j2ee_hw_07.constants.CartControllerConstants.InfoMessages.*;


@Slf4j
@Controller
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }


    @GetMapping("/findAllCarts")
    public String findAllCart(Model model) {
        List<CartDTO> cartDTOS =
                cartService.findAll().stream().map(CartMapper.INSTANCE::toCartDTO).collect(Collectors.toList());
        model.addAttribute("cartDTOS", cartDTOS);
        return "cartList";
    }


    @GetMapping("/getCreateCart")
    public String getCreateCart(Model model) {
        CartDTO cartDTO = new CartDTO();
        model.addAttribute(CART_DTO, cartDTO);
        return "cartCreateForm";
    }

    @PostMapping("/postCreateCart")
    public String postCreateCart(@ModelAttribute(CART_DTO) @Valid CartDTO cartDTO, Model model,
                                 BindingResult bindingResult) {

        String returnForm = "cartSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = CART_ERROR;
        } else {
            final Cart cart = CartMapper.INSTANCE.toCart(cartDTO);
            cart.setId(cartService.createCart(cart));
            model.addAttribute(CART_DTO, CartMapper.INSTANCE.toCartDTO(cart));
        }
        return returnForm;
    }


    @GetMapping("/deleteCartById")
    public String deleteById(@RequestParam int cartId, Model model) {
        String returnForm = CART_MESSAGE;
        if (!cartService.deleteCart(cartId)) {
            log.error(CART_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, CART_NOT_FOUND);
            returnForm = CART_ERROR;
        } else {
            model.addAttribute(MESSAGE, String.format("Cart %d deleted", cartId));
        }
        return returnForm;
    }


    @GetMapping("/getUpdateCart")
    public String getUpdateCart(@RequestParam int cartId, Model model) {
        CartDTO cartDTO = CartMapper.INSTANCE.toCartDTO(cartService.findById(cartId));
        model.addAttribute(CART_DTO, cartDTO);
        return "cartUpdateForm";
    }

    @PostMapping("/postUpdateCart")
    public String putUpdateCart(@ModelAttribute(CART_DTO) @Valid CartDTO cartDTO, Model model,
                                BindingResult bindingResult) {

        String returnForm = "cartSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = CART_ERROR;

        } else {

            final Cart cart = CartMapper.INSTANCE.toCart(cartDTO);
            if (!cartService.updateCart(cart)) {
                log.error(CART_NOT_FOUND);
                model.addAttribute(ERROR_MESSAGE, CART_NOT_FOUND);
                returnForm = CART_ERROR;
            } else {
                model.addAttribute(CART_DTO, CartMapper.INSTANCE.toCartDTO(cart));
            }
        }
        return returnForm;
    }


    @GetMapping("/getCartProducts")
    public String getCartProducts(@RequestParam int cartId, Model model) {
        List<ProductDTO> cartProducts =
                cartService.findCartProducts(cartId).stream().map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
        model.addAttribute(CART_ID, cartId);
        model.addAttribute("cartProducts", cartProducts);
        return "cartProducts";
    }

    @GetMapping("/getCartProductsAdd")
    public String addCartProducts(@RequestParam(CART_ID) int cartId, Model model) {
        List<ProductDTO> productDTOS =
                productService.findAll().stream().map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
        model.addAttribute(CART_ID, cartId);
        model.addAttribute("productDTOS", productDTOS);
        return "cartProductsAdd";
    }

    @GetMapping("/addCartProduct")
    public String addCartProduct(@RequestParam(CART_ID) int cartId, @RequestParam("productId") int productId,
                                 Model model) {
        String returnForm = CART_MESSAGE;
        if (!cartService.addCartProduct(cartId, productId)) {
            log.error(CART_OR_PRODUCT_IS_NOT_FOUND);
            model.addAttribute("errorMessage", CART_OR_PRODUCT_IS_NOT_FOUND);
            returnForm = "cartError";

        } else {
            model.addAttribute(MESSAGE, String.format("Product Id=%d is added", productId));

        }
        return returnForm;
    }

    @GetMapping("/deleteCartProduct")
    public String deleteCartProduct(@RequestParam(CART_ID) int cartId, @RequestParam("productId") int productId,
                                    Model model) {
        String returnForm = CART_MESSAGE;
        if (!cartService.deleteCartProduct(cartId, productId)) {
            log.error(CART_OR_PRODUCT_IS_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, CART_OR_PRODUCT_IS_NOT_FOUND);
            returnForm = CART_ERROR;

        } else {
            model.addAttribute(MESSAGE, String.format("Product Id=%d is deleted", productId));

        }
        return returnForm;
    }


}

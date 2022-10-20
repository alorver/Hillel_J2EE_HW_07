package edu.avo.hillel_j2ee_hw_07.controller;


import edu.avo.hillel_j2ee_hw_07.dto.ProductDTO;
import edu.avo.hillel_j2ee_hw_07.mappers.ProductMapper;
import edu.avo.hillel_j2ee_hw_07.model.Product;
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

import static edu.avo.hillel_j2ee_hw_07.constants.ProductControllerConstants.ErrorMessages.MAIN_FIELDS_ARE_EMPTY;
import static edu.avo.hillel_j2ee_hw_07.constants.ProductControllerConstants.ErrorMessages.PRODUCT_NOT_FOUND;
import static edu.avo.hillel_j2ee_hw_07.constants.ProductControllerConstants.InfoMessages.*;


@Slf4j
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/findAllProducts")
    public String findAllProduct(Model model) {
        List<ProductDTO> productDTOS =
                productService.findAll().stream().map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
        model.addAttribute("productDTOS", productDTOS);
        return "productList";
    }


    @GetMapping("/getCreateProduct")
    public String getCreateProduct(Model model) {
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute(PRODUCT_DTO, productDTO);
        return "productCreateForm";
    }

    @PostMapping("/postCreateProduct")
    public String postCreateProduct(@ModelAttribute(PRODUCT_DTO) @Valid ProductDTO productDTO, Model model,
                                    BindingResult bindingResult) {

        String returnForm = "productSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = PRODUCT_ERROR;
        } else {
            final Product product = ProductMapper.INSTANCE.toProduct(productDTO);
            product.setId(productService.createProduct(product));
            model.addAttribute(PRODUCT_DTO, ProductMapper.INSTANCE.toProductDTO(product));
        }
        return returnForm;
    }


    @GetMapping("/deleteProductById")
    public String deleteById(@RequestParam int productId, Model model) {
        String returnForm = PRODUCT_MESSAGE;
        if (!productService.deleteProduct(productId)) {
            log.error(PRODUCT_NOT_FOUND);
            model.addAttribute(ERROR_MESSAGE, PRODUCT_NOT_FOUND);
            returnForm = PRODUCT_ERROR;
        } else {
            model.addAttribute(MESSAGE, String.format("Product %d deleted", productId));
        }
        return returnForm;
    }


    @GetMapping("/getUpdateProduct")
    public String getUpdateProduct(@RequestParam int productId, Model model) {
        ProductDTO productDTO = ProductMapper.INSTANCE.toProductDTO(productService.findById(productId));
        model.addAttribute(PRODUCT_DTO, productDTO);
        return "productUpdateForm";
    }

    @PostMapping("/postUpdateProduct")
    public String putUpdateProduct(@ModelAttribute(PRODUCT_DTO) @Valid ProductDTO productDTO, Model model,
                                   BindingResult bindingResult) {

        String returnForm = "productSaveSuccess";
        if (bindingResult.hasErrors()) {
            log.error(MAIN_FIELDS_ARE_EMPTY);
            model.addAttribute(ERROR_MESSAGE, MAIN_FIELDS_ARE_EMPTY);
            returnForm = PRODUCT_ERROR;

        } else {

            final Product product = ProductMapper.INSTANCE.toProduct(productDTO);
            if (!productService.updateProduct(product)) {
                log.error(PRODUCT_NOT_FOUND);
                model.addAttribute(ERROR_MESSAGE, PRODUCT_NOT_FOUND);
                returnForm = PRODUCT_ERROR;
            } else {
                model.addAttribute(PRODUCT_DTO, ProductMapper.INSTANCE.toProductDTO(product));
            }
        }
        return returnForm;
    }


}

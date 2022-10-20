package edu.avo.hillel_j2ee_hw_07.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDTO {

    private Integer id;

    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;


}

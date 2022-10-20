package edu.avo.hillel_j2ee_hw_07.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class CartDTO {

    private Integer id;
    @NotBlank
    private String description;
    private BigDecimal summa = new BigDecimal("0.00");


}

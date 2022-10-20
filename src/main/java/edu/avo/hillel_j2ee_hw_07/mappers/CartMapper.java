package edu.avo.hillel_j2ee_hw_07.mappers;

import edu.avo.hillel_j2ee_hw_07.dto.CartDTO;
import edu.avo.hillel_j2ee_hw_07.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    CartDTO toCartDTO(Cart cart);
    Cart toCart(CartDTO cartDTO);
}

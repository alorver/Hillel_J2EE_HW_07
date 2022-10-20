package edu.avo.hillel_j2ee_hw_07.mappers;

import edu.avo.hillel_j2ee_hw_07.dto.ShopDTO;
import edu.avo.hillel_j2ee_hw_07.model.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper( ShopMapper.class );
    ShopDTO toShopDTO(Shop shop);
    Shop toShop(ShopDTO shopDTO);
}

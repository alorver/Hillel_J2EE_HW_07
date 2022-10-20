package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Person;
import edu.avo.hillel_j2ee_hw_07.model.Product;
import edu.avo.hillel_j2ee_hw_07.model.Shop;

import java.util.List;
import java.util.Set;

public interface ShopService {
    Integer createShop(Shop shop);
    boolean deleteShop(Integer shopId);
    boolean updateShop(Shop shop);
    List<Shop> findAll();
    Shop findById(Integer shopId);

    boolean addShopPerson(Integer shopId, Integer personId);
    boolean deleteShopPerson(Integer shopId, Integer personId);
    Set<Person> findShopPersons(Integer shopId);

    boolean addShopProduct(Integer shopId, Integer productId);
    boolean deleteShopProduct(Integer shopId, Integer productId);
    Set<Product> findShopProducts(Integer shopId);

}

package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Cart;
import edu.avo.hillel_j2ee_hw_07.model.Product;

import java.util.List;
import java.util.Set;

public interface CartService {
    Integer createCart(Cart cart);
    List<Cart> findAll();
    Cart findById(Integer cartId);

    boolean deleteCart(Integer cartId);
    boolean updateCart(Cart cart);

    boolean addCartProduct(Integer cartId, Integer productId);
    boolean deleteCartProduct(Integer cartId, Integer productId);
    Set<Product> findCartProducts(Integer cartId);
}

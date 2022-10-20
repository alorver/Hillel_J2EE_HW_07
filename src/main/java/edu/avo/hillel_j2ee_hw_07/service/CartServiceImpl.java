package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Cart;
import edu.avo.hillel_j2ee_hw_07.model.Product;
import edu.avo.hillel_j2ee_hw_07.repository.CartRepository;
import edu.avo.hillel_j2ee_hw_07.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CartServiceImpl implements edu.avo.hillel_j2ee_hw_07.service.CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Integer createCart(Cart cart) {
        return cartRepository.save(cart).getId();
    }

    @Override
    public List<Cart> findAll() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart findById(Integer cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }


    @Override
    public boolean deleteCart(Integer cartId) {
        boolean result = false;
        if (cartRepository.findById(cartId).isPresent()) {
            cartRepository.deleteById(cartId);
            result = true;
        }
        return result;
    }

    @Override
    public boolean updateCart(Cart cart) {
        return cartRepository.findById(cartRepository.save(cart).getId()).isPresent();
    }

    @Override
    public boolean addCartProduct(Integer cartId, Integer productId) {
        boolean result = false;
        Optional<Cart> cartLocal = cartRepository.findById(cartId);
        Optional<Product> productLocal = productRepository.findById(productId);
        if (cartLocal.isPresent() &&
                productLocal.isPresent() &&
                cartLocal.get().getProductSet().add(productLocal.get())) {

            cartLocal.get().setSumma(cartLocal.get().getSumma()
                    .add(productLocal.get().getPrice())
                    .setScale(2, RoundingMode.HALF_UP));
            result = updateCart(cartLocal.get());
        }
        return result;
    }


    @Override
    public boolean deleteCartProduct(Integer cartId, Integer productId) {
        boolean result = false;
        Optional<Cart> cartLocal = cartRepository.findById(cartId);
        Optional<Product> productLocal = productRepository.findById(productId);
        if (cartLocal.isPresent() &&
                productLocal.isPresent() &&
                cartLocal.get().getProductSet().remove(productLocal.get())) {

            cartLocal.get().setSumma(cartLocal.get().getSumma()
                    .subtract(productLocal.get().getPrice())
                    .setScale(2, RoundingMode.HALF_UP));
            result = updateCart(cartLocal.get());

        }
        return result;
    }


    @Override
    public Set<Product> findCartProducts(Integer cartId) {
        return findById(cartId) == null ? Collections.emptySet() : findById(cartId).getProductSet();
    }


}

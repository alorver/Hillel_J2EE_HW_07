package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Product;
import edu.avo.hillel_j2ee_hw_07.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Integer createProduct(Product product) {
        return productRepository.save(product).getId();
    }


    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }


    @Override
    public boolean deleteProduct(Integer productId) {
        boolean result = false;
        if (productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
            result = true;
        }
        return result;
    }


    @Override
    public boolean updateProduct(Product product) {
        Optional<Product> productLocal = productRepository.findById(product.getId());
        if (productLocal.isPresent() && product.getPrice() != null) {
            BigDecimal diffPrice = product.getPrice().subtract(productLocal.get().getPrice());

            productLocal.get().getCartSet().forEach(cart -> cart.setSumma(cart.getSumma().add(diffPrice)));
        }
        return productRepository.findById(productRepository.save(product).getId()).isPresent();
    }


}

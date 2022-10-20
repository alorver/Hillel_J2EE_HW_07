package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Product;

import java.util.List;

public interface ProductService {
    Integer createProduct(Product product);
    List<Product> findAll();
    Product findById(Integer productId);

    boolean deleteProduct(Integer productId);
    boolean updateProduct(Product product);
}

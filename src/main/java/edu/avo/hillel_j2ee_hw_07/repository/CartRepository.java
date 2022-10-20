package edu.avo.hillel_j2ee_hw_07.repository;

import edu.avo.hillel_j2ee_hw_07.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}

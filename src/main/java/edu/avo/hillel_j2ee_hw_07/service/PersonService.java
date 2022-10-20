package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Cart;
import edu.avo.hillel_j2ee_hw_07.model.Person;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Set;

public interface PersonService extends UserDetailsService {
    Integer createPerson(Person person);

    List<Person> findAll();

    Person findById(Integer personId);

    boolean deletePerson(Integer personId);

    boolean updatePerson(Person person);

    boolean addPersonCart(Integer personId, Integer cartId);

    boolean deletePersonCart(Integer personId, Integer cartId);

    Set<Cart> findPersonCarts(Integer personId);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

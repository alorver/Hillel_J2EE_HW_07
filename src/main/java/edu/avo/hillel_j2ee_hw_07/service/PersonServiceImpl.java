package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Cart;
import edu.avo.hillel_j2ee_hw_07.model.Person;
import edu.avo.hillel_j2ee_hw_07.model.Role;
import edu.avo.hillel_j2ee_hw_07.repository.CartRepository;
import edu.avo.hillel_j2ee_hw_07.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonServiceImpl implements edu.avo.hillel_j2ee_hw_07.service.PersonService {

    private final PersonRepository personRepository;
    private final CartRepository cartRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public PersonServiceImpl(PersonRepository personRepository, CartRepository cartRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personRepository = personRepository;
        this.cartRepository = cartRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Integer createPerson(Person person) {
        person.setRoleSet(Collections.singleton(new Role(2, "ROLE_CUSTOMER")));
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        return personRepository.save(person).getId();
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person findById(Integer personId) {
        return personRepository.findById(personId).orElse(null);
    }


    @Override
    public boolean deletePerson(Integer personId) {
        boolean result = false;
        if (personRepository.findById(personId).isPresent()) {
            personRepository.deleteById(personId);
            result = true;
        }
        return result;
    }

    @Override
    public boolean updatePerson(Person person) {
        return personRepository.findById(personRepository.save(person).getId()).isPresent();
    }


    @Override
    public boolean addPersonCart(Integer personId, Integer cartId) {
        boolean result = false;
        Optional<Person> personLocal = personRepository.findById(personId);
        Optional<Cart> cartLocal = cartRepository.findById(cartId);

        if (personLocal.isPresent() &&
                cartLocal.isPresent() &&
                personLocal.get().getCartSet().add(cartLocal.get())) {

            cartLocal.get().setPerson(personLocal.get());
            result = updatePerson(personLocal.get());
        }
        return result;
    }


    @Override
    public boolean deletePersonCart(Integer personId, Integer cartId) {
        boolean result = false;
        Optional<Person> personLocal = personRepository.findById(personId);
        Optional<Cart> cartLocal = cartRepository.findById(cartId);

        if (personLocal.isPresent() &&
                cartLocal.isPresent() &&
                personLocal.get().getCartSet().remove(cartLocal.get())) {

            cartLocal.get().setPerson(null);
            result = updatePerson(personLocal.get());
        }
        return result;
    }


    @Override
    public Set<Cart> findPersonCarts(Integer personId) {
        return findById(personId) == null ? Collections.emptySet() : findById(personId).getCartSet();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException(String.format("Person with %s name not found", username));
        }

        return person;
    }
}

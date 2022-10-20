package edu.avo.hillel_j2ee_hw_07.service;

import edu.avo.hillel_j2ee_hw_07.model.Person;
import edu.avo.hillel_j2ee_hw_07.model.Product;
import edu.avo.hillel_j2ee_hw_07.model.Shop;
import edu.avo.hillel_j2ee_hw_07.repository.PersonRepository;
import edu.avo.hillel_j2ee_hw_07.repository.ProductRepository;
import edu.avo.hillel_j2ee_hw_07.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ShopServiceImpl implements edu.avo.hillel_j2ee_hw_07.service.ShopService {

    private final ShopRepository shopRepository;
    private final PersonRepository personRepository;
    private final ProductRepository productRepository;


    public ShopServiceImpl(ShopRepository shopRepository, PersonRepository personRepository,
                           ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Integer createShop(Shop shop) {
        return shopRepository.save(shop).getId();
    }

    @Override
    public List<Shop> findAll() {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public Shop findById(Integer shopId) {
        return shopRepository.findById(shopId).orElse(null);
    }


    @Override
    public boolean deleteShop(Integer shopId) {
        boolean result = false;
        if (shopRepository.findById(shopId).isPresent()) {
            shopRepository.deleteById(shopId);
            result = true;
        }
        return result;
    }


    @Override
    public boolean updateShop(Shop shop) {
        return shopRepository.findById(shopRepository.save(shop).getId()).isPresent();
    }


    @Override
    public boolean addShopPerson(Integer shopId, Integer personId) {
        boolean result = false;
        Optional<Shop> shopLocal = shopRepository.findById(shopId);
        Optional<Person> personLocal = personRepository.findById(personId);

        if (shopLocal.isPresent() &&
                personLocal.isPresent() &&
                shopLocal.get().getPersonSet().add(personLocal.get())) {
            result = updateShop(shopLocal.get());
        }

        return result;
    }


    @Override
    public boolean deleteShopPerson(Integer shopId, Integer personId) {
        boolean result = false;
        Optional<Shop> shopLocal = shopRepository.findById(shopId);
        Optional<Person> personLocal = personRepository.findById(personId);

        if (shopLocal.isPresent() &&
                personLocal.isPresent() &&
                shopLocal.get().getPersonSet().remove(personLocal.get())) {
            result = updateShop(shopLocal.get());
        }

        return result;
    }


    @Override
    public Set<Person> findShopPersons(Integer shopId) {
        return findById(shopId) == null ? Collections.emptySet() : findById(shopId).getPersonSet();
    }

    @Override
    public boolean addShopProduct(Integer shopId, Integer productId) {
        boolean result = false;
        Optional<Shop> shopLocal = shopRepository.findById(shopId);
        Optional<Product> productLocal = productRepository.findById(productId);

        if (shopLocal.isPresent() &&
                productLocal.isPresent() &&
                shopLocal.get().getProductSet().add(productLocal.get())) {

            productLocal.get().setShop(shopLocal.get());
            result = updateShop(shopLocal.get());
        }

        return result;
    }


    @Override
    public boolean deleteShopProduct(Integer shopId, Integer productId) {
        boolean result = false;
        Optional<Shop> shopLocal = shopRepository.findById(shopId);
        Optional<Product> productLocal = productRepository.findById(productId);

        if (shopLocal.isPresent() &&
                productLocal.isPresent() &&
                shopLocal.get().getProductSet().remove(productLocal.get())) {

            productLocal.get().setShop(null);
            result = updateShop(shopLocal.get());
        }

        return result;
    }


    @Override
    public Set<Product> findShopProducts(Integer shopId) {
        return findById(shopId) == null ? Collections.emptySet() : findById(shopId).getProductSet();
    }


}

package edu.avo.hillel_j2ee_hw_07.repository;

import edu.avo.hillel_j2ee_hw_07.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Person, Integer> {
}

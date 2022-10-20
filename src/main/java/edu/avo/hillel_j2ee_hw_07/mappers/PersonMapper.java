package edu.avo.hillel_j2ee_hw_07.mappers;

import edu.avo.hillel_j2ee_hw_07.dto.PersonDTO;
import edu.avo.hillel_j2ee_hw_07.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDTO toPersonDTO(Person person);
    Person toPerson(PersonDTO personDTO);
}

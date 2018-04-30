package ru.bars.test.server.mappers;

import org.springframework.stereotype.Service;
import ru.bars.test.server.dto.Person;
import ru.bars.test.server.entity.PersonEntity;

@Service
public class Mapper {

   private Mapper(){}

   public static Person mapToDto(PersonEntity entity){
       return new Person(entity.getFirstname(), entity.getLastname(), entity.getPatronymic(), entity.getPosition());
   }

   public static PersonEntity mapToEntity(Person dto) {
       return new PersonEntity(dto.getFirstname(), dto.getLastname(), dto.getPatronymic(), dto.getPosition());
   }
}

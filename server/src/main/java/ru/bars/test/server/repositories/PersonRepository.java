package ru.bars.test.server.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bars.test.server.entity.PersonEntity;
import java.util.List;
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    List<PersonEntity> findAll();
}

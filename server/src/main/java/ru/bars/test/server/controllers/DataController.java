package ru.bars.test.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bars.test.server.dto.Person;
import ru.bars.test.server.mappers.Mapper;
import ru.bars.test.server.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/data")
public class DataController {

    @Autowired
    private PersonRepository repository;
    @PostMapping(value = "/get")
    public List<Person> getAll(){
        return repository.findAll().stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    @PutMapping(value = "/save")
    public Boolean save(Person dto){
        try {
            repository.save(Mapper.mapToEntity(dto));
            return Boolean.TRUE;
        } catch (Exception e){
            return Boolean.FALSE;
        }
    }

}

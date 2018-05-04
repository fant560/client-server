package ru.bars.test.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping(value = "/get")
    public List<Person> getAll(){
        return repository.findAll().stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    @PutMapping(value = "/save")
    public void save(@RequestBody Person dto){
        repository.save(Mapper.mapToEntity(dto));
    }

}

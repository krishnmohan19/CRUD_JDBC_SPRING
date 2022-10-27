package com.example.springCRUD.controller;

import com.example.springCRUD.modle.Person;
import com.example.springCRUD.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){

        this.personService=personService;
    }
    @GetMapping("/person/{id}")
    public Person getUser(@PathVariable("id") long id){
        System.out.println(id+"in controler");
        return personService.getById(id);
    }
    @PostMapping("/person")
    public String addPerson(@RequestBody Person person){

        personService.addPerson(person);
        return "Person Successfully added";
    }

    @GetMapping("/person")
    public List<Person> getAllPerson(){

        return personService.getAllPerson();
    }
    @PutMapping("person/{id}")
    public String updatePerson(@PathVariable("id") long id,@RequestBody Person person){
        Person exist=personService.getById(id);

        if(exist==null){
            return "No person found to update";
        }
        else{
            personService.update(person,id);
            return "Person updated successfully";
        }
    }
    @DeleteMapping("person/{id}")
    public String deletePerson(@PathVariable long id){
        Person exist=personService.getById(id);

        if(exist==null){
            return "No person found to delete";
        }
        else{
            personService.deleteBySid(id);
            return "Person deleted successfully";
        }
    }
}

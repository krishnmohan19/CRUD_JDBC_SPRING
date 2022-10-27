package com.example.springCRUD.service;

import com.example.springCRUD.modle.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PersonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addPerson(Person person){
        String querry="INSERT INTO person(id,name) VALUES (?,?)";
        return jdbcTemplate.update(querry,person.getId(),person.getName());
    }
    public Person getById(long id){
        String querry="SELECT * FROM person WHERE id=?";
        Person person=jdbcTemplate.queryForObject(querry,(rs, rowNum) -> {
            return new Person(rs.getLong("id"),rs.getString("name"));
        },id);
        return person;
    }
    public List<Person> getAllPerson(){
        String querry="SELECT * FROM person";
        return jdbcTemplate.query(querry,(rs,rowNum)->{
            return new Person(rs.getLong("id"),rs.getString("name"));
        });
    }
    public int update(Person person,long id) {
        String query = "UPDATE person SET name = ? where id=?";
        return jdbcTemplate.update(query, person.getName(),id);
    }

    public int deleteBySid(long id) {
        String query = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }
}

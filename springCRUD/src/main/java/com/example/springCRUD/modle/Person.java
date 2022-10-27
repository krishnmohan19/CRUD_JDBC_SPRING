package com.example.springCRUD.modle;

public class Person {
    private long id;
    private String name;
    public Person(long id,String name){
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return this.name;
    }
    public long getId() {
        return this.id;
    }
}

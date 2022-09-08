package org.uka0001.model;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String name;
    private String age;
    private Address address;
    private List<Person> friends;
}

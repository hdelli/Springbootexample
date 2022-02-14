package com.hajr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@SpringBootApplication
@RestController
public class SpringBootApplicationPeople {

    static List<Person> person = new ArrayList<>();


    public static void main(String[] args) {

        Person marcy = new Person(123, "Marcy", 23);
        Person suad = new Person(677, "Suad", 22);
        Person alex = new Person(455, "Alex", 25);

        person.add(marcy);
        person.add(alex);
        person.add(suad);
        SpringApplication.run(SpringBootApplicationPeople.class, args);

    }

    @GetMapping("people/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        // filter list and return person that matches id otherwise return null

        for (Person person : person) {
            if (id == person.getId()) {
                return person;
            }
        }
        return null;
    }
}









        class Person {

            private int id;
            private String name;
            private int age;

            public Person(int id, String name, int age) {
                this.id = id;
                this.name = name;
                this.age = age;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return id == person.id && age == person.age && Objects.equals(name, person.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, name, age);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }











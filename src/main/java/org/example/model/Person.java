package org.example.model;

import java.util.Objects;

public class Person {

    private Integer id;
    private String name;
    private String email;
    private String office;
    private Integer userId;

    public Person(Integer id, String name, String email, String office, Integer userId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.office = office;
        this.userId = userId;
    }

    public Person(String name, String email, String office, Integer userId) {
        this.name = name;
        this.email = email;
        this.office = office;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", office='" + office + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

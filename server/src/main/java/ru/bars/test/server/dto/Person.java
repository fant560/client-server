package ru.bars.test.server.dto;

import java.io.Serializable;

/**
 * По идее, dto и rest-либа клиентская должны быть в отдельных модулях
 */
public class Person implements Serializable {

    private String firstname;
    private String lastname;
    private String patronymic;
    private String position;

    public Person() {
    }

    public Person(String firstname, String lastname, String patronymic, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.position = position;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.lastname + " " + this.firstname + " " + this.patronymic + " " + this.position;
    }
}

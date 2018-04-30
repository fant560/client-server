package ru.bars.test.client.dto;

public class Person {

    private String firstname;
    private String lastname;
    private String patronymic;
    private String position;

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
}

package ru.bars.test.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 3567653491060394677L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    //hibernate сам ставит allocation size в 50
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @JsonIgnore
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String patronymic;
    @Column
    private String position;
    //hibernate + jackson
    public PersonEntity() {
    }
    //удобство
    public PersonEntity(String firstname, String lastname, String patronymic, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
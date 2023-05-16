package br.com.projeto.mentoria.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity(name = "Student")
@Table(name = "Student")
public class Student extends Person{
    @Column(name = "birthdayDate", nullable = false)
    private Date birthdayDate;

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}

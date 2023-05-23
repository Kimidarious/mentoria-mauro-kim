package br.com.projeto.mentoria.domain;

import jakarta.persistence.*;

import java.util.Date;


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

    public boolean isOldEnough() {
        if (birthdayDate != null) {
            Date currentDate = new Date();
            long sixYearsInMillis = 6L * 365L * 24L * 60L * 60L * 1000L;
            Date sixYearsAgo = new Date(currentDate.getTime() - sixYearsInMillis);
            return birthdayDate.before(sixYearsAgo);
        }
        return false;
    }
}

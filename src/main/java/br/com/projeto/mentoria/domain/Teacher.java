package br.com.projeto.mentoria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.Period;


@Entity(name = "Teacher")
@Table(name = "Teacher")
public class Teacher extends Person {

    @Column(name = "age", nullable = false)
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public boolean isAdult() {
        if (age != null) {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = currentDate.minusYears(age);
            Period period = Period.between(birthDate, currentDate);
            return period.getYears() >= 18;
        }
        return false;
    }
}
package br.com.projeto.mentoria.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Teacher")
@Table(name = "Teacher")
public class Teacher extends Person{

    @Column(name = "age", nullable = false)
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

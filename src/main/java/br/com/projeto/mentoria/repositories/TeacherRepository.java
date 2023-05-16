package br.com.projeto.mentoria.repositories;

import br.com.projeto.mentoria.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findByCpf(String cpf);
}

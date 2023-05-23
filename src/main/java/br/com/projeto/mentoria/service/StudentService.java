package br.com.projeto.mentoria.service;

import br.com.projeto.mentoria.domain.Student;
import br.com.projeto.mentoria.exceptions.ApiException;
import br.com.projeto.mentoria.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(int id) {
        var result = studentRepository.findById(id);
        return result.orElseThrow(() -> new ApiException("Entity not found.", HttpStatus.NOT_FOUND));
    }

    public Student insert(Student object) {
        var student = studentRepository.findByCpf(object.getCpf());

        if (student == null) {
            return studentRepository.save(student);
        } else if (student.getStatus()) {
            throw new ApiException("This teacher is already exists and your status is active.",
                    HttpStatus.CONFLICT);
        } else {
            throw new ApiException("This teacher is already exists and your status is desactive.",
                    HttpStatus.BAD_REQUEST);
        }
    }

    public void update(Student student, int id) {
        student.setId(id);
        studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
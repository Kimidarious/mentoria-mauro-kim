package br.com.projeto.mentoria.service;

import br.com.projeto.mentoria.domain.Teacher;
import br.com.projeto.mentoria.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher insert(Teacher object) {
        return teacherRepository.save(object);
    }

	public Teacher findById(int id){
       var result = teacherRepository.findById(id);
       return result.get();
	}

	public void update(Teacher object, int id){
        object.setId(id);
        teacherRepository.save(object);
	}

	public void delete(int id){
        teacherRepository.deleteById(id);
    }
}

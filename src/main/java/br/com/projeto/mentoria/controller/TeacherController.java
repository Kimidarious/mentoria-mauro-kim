package br.com.projeto.mentoria.controller;

import br.com.projeto.mentoria.domain.Teacher;
import br.com.projeto.mentoria.service.TeacherService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAll(){
        return teacherService.findAll();
    }

    @PostMapping
    public Teacher insert(@RequestBody Teacher teacher){
        return teacherService.insert(teacher);
    }

    @GetMapping("{id}")
    public Teacher getById(@PathVariable(name = "id") int id){
        return teacherService.findById(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Teacher teacher, @PathVariable(name = "id") int id){
        teacherService.update(teacher, id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") int id){
        teacherService.delete(id);
    }
}

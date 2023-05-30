package br.com.projeto.mentoria.service;

import br.com.projeto.mentoria.domain.Teacher;
import br.com.projeto.mentoria.repositories.TeacherRepository;
import br.com.projeto.mentoria.exceptions.ApiException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(int id) {
        var result = teacherRepository.findById(id);
        return result.orElseThrow(() -> new ApiException("Entity not found.", HttpStatus.NOT_FOUND));
    }

    public Teacher insert(Teacher object) {
        validate(object);
        var teacher = teacherRepository.findByCpf(object.getCpf());

        if (teacher == null) {
            return teacherRepository.save(object);
        } else if (teacher.getStatus()) {
            throw new ApiException("This teacher is already exists and your status is active.", HttpStatus.CONFLICT);
        } else {
            throw new ApiException("This teacher is already exists and your status is desactive.", HttpStatus.BAD_REQUEST);
        }
    }

    private void validate(Teacher teacher) {
        List<String> erros = teacher.validate();
        if (erros.isEmpty()) {
            throw new ApiException(erros, HttpStatus.BAD_REQUEST);
        }
    }

    public void update(Teacher teacher, int id) {
        teacher.setId(id);
        teacherRepository.save(teacher);
    }

    public void delete(int id) {
        teacherRepository.deleteById(id);
    }

//    private void Reflexao(Person person) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            //Serializa o obejto em uma string JSON
//            String jsonString = objectMapper.writeValueAsString(person);
//            System.out.println("Objeto serializado em JSON: " + jsonString);
//
//            var props = person.getClass().getDeclaredFields();
//            for (var prop : props) { //percorre cada prop
//                try {
//                    var nameProp = prop.getName();//recupera nome da prop
//                    System.out.println(nameProp);
//
//                    prop.setAccessible(true);//vai dar erro na linha abiaxo se a prop for private, essa linha permite
//                    // acessar
//                    var valueProp = prop.get(person);//recupera valor da prod
//                    System.out.println(Optional.ofNullable(valueProp).map(Object::toString).orElse(""));
//                } catch (Exception ex) {
//                    var e = ex.getMessage();
//                }
//
//            }
//            //alterando valor em tempo de execução
//            var propFilhod = person.getClass()
//                    .getField("TesteDosFera"); //acessa a prop TesteDosFera que está na classe filha
//            propFilhod.set(person, "Teste dos Feras setado em tempo de execução"); //seta um valor pra ela
//
//            var propObject = propFilhod.get(person);//recupera valor
//
//            System.out.println(propObject.toString());
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}
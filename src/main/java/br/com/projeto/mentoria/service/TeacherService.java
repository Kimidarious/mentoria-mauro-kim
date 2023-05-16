package br.com.projeto.mentoria.service;

import br.com.projeto.mentoria.domain.Teacher;
import br.com.projeto.mentoria.exceptions.ApiException;
import br.com.projeto.mentoria.repositories.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {

        return teacherRepository.findAll();
    }

    public Teacher insert(Teacher teacher) {
        var teacherCpf = teacherRepository.findByCpf(teacher.getCpf());

        if (teacherCpf == null) {
            return teacherRepository.save(teacher);
        } else if (teacher.getStatus()) {
            throw new ApiException("This teacher is already exists and your status is active."
                    , HttpStatus.CONFLICT);
        } else {
            throw new ApiException("This teacher is already exists and your status is desactive.",
                    HttpStatus.BAD_REQUEST);
        }
        //verificar se o cpf do teacher ja existe no banco se existir não vou salvar se nao existir eu salvo
        //se o objeto existir e o campo ativo for false vai retonrar mensagem pára o usuario dizendo que o professor ja existe no banco e esta dfsativado

    }

	public Teacher findById(int id){
       var result = teacherRepository.findById(id);
       return result.orElseThrow(() -> new ApiException("Entity not found." , HttpStatus.NOT_FOUND));
	}

	public void update(Teacher teacher, int id){

        teacher.setId(id);
        teacherRepository.save(teacher);
	}

	public void delete(int id){
        teacherRepository.deleteById(id);
    }
}

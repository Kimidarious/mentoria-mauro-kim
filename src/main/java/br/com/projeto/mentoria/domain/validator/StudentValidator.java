package br.com.projeto.mentoria.domain.validator;

import br.com.projeto.mentoria.domain.Student;

import java.time.LocalDate;
import java.util.List;


public class StudentValidator extends PersonValidator {
    public List<String> validate(Student student) {
        List<String> erros = super.validate(student);

        var actualDate = LocalDate.now().minusYears(6);
        if (actualDate.isBefore(student.getBirthdayDate())) {
            erros.add("The child must be more than 6 years. ");
        }
        return erros;
    }
}

package ec.edu.espe.ejez.lab3nosql.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ec.edu.espe.ejez.lab3nosql.dto.StudentDto;
import ec.edu.espe.ejez.lab3nosql.dto.StudentExistingDto;
import ec.edu.espe.ejez.lab3nosql.dto.StudentNewDto;

public interface StudentService {
    StudentDto addStudent(StudentNewDto studentNewDto);
    StudentDto updateStudent(StudentExistingDto studentExistingDto);
    void deleteStudent(String studentId);
    StudentDto getStudentById(String studentId);
    Page<StudentDto> getAllStudents(Pageable pageable);
}
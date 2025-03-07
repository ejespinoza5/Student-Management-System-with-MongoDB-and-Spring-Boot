package ec.edu.espe.ejez.lab3nosql.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ec.edu.espe.ejez.lab3nosql.dto.StudentDto;
import ec.edu.espe.ejez.lab3nosql.dto.StudentExistingDto;
import ec.edu.espe.ejez.lab3nosql.dto.StudentNewDto;
import ec.edu.espe.ejez.lab3nosql.exception.ResourceNotFoundException;
import ec.edu.espe.ejez.lab3nosql.model.Student;
import ec.edu.espe.ejez.lab3nosql.repository.StudentRepository;
import ec.edu.espe.ejez.lab3nosql.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public StudentDto addStudent(StudentNewDto studentNewDto) {
        Student student = new Student();
        student.setId(studentNewDto.getId());
        student.setFirstName(studentNewDto.getFirstName());
        student.setLastName(studentNewDto.getLastName());
        student.setEmail(studentNewDto.getEmail());
        student.setContactNumber(studentNewDto.getContactNumber());
        student.setCourseName(studentNewDto.getCourseName());
        student = studentRepository.save(student);
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setContactNumber(student.getContactNumber());
        studentDto.setCourseName(student.getCourseName());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
    }
    @Override
    public StudentDto updateStudent(StudentExistingDto studentExistingDto) {
        Optional<Student> studentOpt =
                studentRepository.findById(studentExistingDto.getId());
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        Student student = studentOpt.get();
        student.setFirstName(studentExistingDto.getFirstName());
        student.setLastName(studentExistingDto.getLastName());
        student.setEmail(studentExistingDto.getEmail());
        student.setContactNumber(studentExistingDto.getContactNumber());
        student.setCourseName(studentExistingDto.getCourseName());
        student = studentRepository.save(student);
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setContactNumber(student.getContactNumber());
        studentDto.setCourseName(student.getCourseName());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
    }
    @Override
    public void deleteStudent(String studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        studentRepository.deleteById(studentId);
    }
    @Override
    public StudentDto getStudentById(String studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        Student student = studentOpt.get();
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setContactNumber(student.getContactNumber());
        studentDto.setCourseName(student.getCourseName());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
    }
    @Override
    public Page<StudentDto> getAllStudents(Pageable pageable) {
        Page<Student> studentsPage = studentRepository.findAll(pageable);
        List<StudentDto> studentsDto = new ArrayList<>();
        Page<StudentDto> studentsDtoPage = new PageImpl<>(studentsDto, pageable,
                0);
        if (studentsPage != null && !studentsPage.isEmpty()) {
            studentsPage.getContent().forEach(student -> {
                StudentDto studentDto = new StudentDto();
                studentDto.setId(student.getId());
                studentDto.setFirstName(student.getFirstName());
                studentDto.setLastName(student.getLastName());
                studentDto.setEmail(student.getEmail());
                studentDto.setContactNumber(student.getContactNumber());
                studentDto.setCourseName(student.getCourseName());
                studentDto.setCreated(student.getCreated());
                studentDto.setModified(student.getModified());
                studentsDto.add(studentDto);
            });
            studentsDtoPage =
                    new PageImpl<>(studentsDto, pageable,
                            studentsPage.getTotalElements());
        }
        return studentsDtoPage;
    }
}


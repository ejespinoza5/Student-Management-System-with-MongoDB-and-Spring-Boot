package ec.edu.espe.ejez.lab3nosql.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.espe.ejez.lab3nosql.dto.StudentDto;
import ec.edu.espe.ejez.lab3nosql.dto.StudentExistingDto;
import ec.edu.espe.ejez.lab3nosql.dto.StudentNewDto;
import ec.edu.espe.ejez.lab3nosql.service.StudentService;
@RestController
@RequestMapping(path = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping(path = "/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody @Valid
                                                 StudentNewDto studentNewDto) {
        StudentDto student = studentService.addStudent(studentNewDto);
        return ResponseEntity.ok(student);
    }
    @PostMapping(path = "/update")
    public ResponseEntity<StudentDto> updateStudent(
            @RequestBody @Valid StudentExistingDto studentExistingDto) {
        StudentDto student = studentService.updateStudent(studentExistingDto);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping(path = "/{studentId}/delete")
    public void deleteStudent(@PathVariable(name = "studentId") String studentId) {
        studentService.deleteStudent(studentId);
    }
    @GetMapping(path = "/{studentId}")
    public ResponseEntity<StudentDto> getStudent(
            @PathVariable(name = "studentId") String studentId) {
        StudentDto student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<Page<StudentDto>> getStudents(@PageableDefault(page = 0,
            size = 30) @SortDefault.SortDefaults({@SortDefault(sort = "modified",
            direction = Sort.Direction.DESC)}) Pageable pageable) {
        Page<StudentDto> students = studentService.getAllStudents(pageable);
        return ResponseEntity.ok(students);
    }
}

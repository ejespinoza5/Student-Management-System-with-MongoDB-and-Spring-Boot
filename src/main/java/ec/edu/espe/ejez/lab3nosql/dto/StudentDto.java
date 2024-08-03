package ec.edu.espe.ejez.lab3nosql.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String courseName;
    private LocalDateTime created;
    private LocalDateTime modified;
}

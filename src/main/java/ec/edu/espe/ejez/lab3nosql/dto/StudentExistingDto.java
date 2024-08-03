package ec.edu.espe.ejez.lab3nosql.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Data
public class StudentExistingDto {
    @NotNull(message = "id cannot be empty")
    private String id;

    @NotNull(message = "firstName cannot be empty")
    @Size(min = 2, max = 30, message = "firstName must be atleast of 2 letters and not more then 100\nletters")
    private String firstName;

    @NotNull(message = "lastName cannot be empty")
    @Size(min = 2, max = 30, message = "lastName must be atleast of 2 letters and not more then 100\nletters")
    private String lastName;

    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;

    private String contactNumber;
    private String courseName;
    private LocalDateTime created;
    private LocalDateTime modified;
}
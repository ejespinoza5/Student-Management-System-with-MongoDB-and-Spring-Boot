package ec.edu.espe.ejez.lab3nosql.exception;


import lombok.Data;

@Data
public class Error {
    private String message;
    private int status;
    private Long timestamp;

}

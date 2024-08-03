package ec.edu.espe.ejez.lab3nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class Lab3NoSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab3NoSqlApplication.class, args);
    }

}

package ec.edu.espe.ejez.lab3nosql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.ejez.lab3nosql.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    public Page<Student> findAll(Pageable pageable);
}
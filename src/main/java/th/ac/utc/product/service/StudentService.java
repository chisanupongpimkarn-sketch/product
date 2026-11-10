package th.ac.utc.product.service;

import java.util.List;
import java.util.Optional;
import th.ac.utc.product.mobel.Student;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Student save(Student student);
}

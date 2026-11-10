package th.ac.utc.product.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ac.utc.product.mobel.Student;
import th.ac.utc.product.service.InMemoryStudentService;
import th.ac.utc.product.service.StudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService = new InMemoryStudentService();

    @GetMapping("/students")
    public List<Student> list(){
        return studentService.findAll();
    }
    @GetMapping("/student")
    public Student one (@RequestParam Long id){
        return studentService.findById(id).orElse(null);
    }
}

package student.com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import student.com.demo.model.Student;
import student.com.demo.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/stud")
public class StudentController {
      
	@Autowired
	   private StudentService studentService;
	
	 @PostMapping("/addnew")
	    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	        Student savedStudent = studentService.saveStudent(student);
	        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
	        Student student = studentService.getStudentById(id);
	        if (student != null) {
	            return new ResponseEntity<>(student, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/getall")
	    public ResponseEntity<List<Student>> getAllStudents() {
	        List<Student> students = studentService.getAllStudents();
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
	        studentService.deleteStudent(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}

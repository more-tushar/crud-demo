package student.com.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.com.demo.model.Student;
import student.com.demo.repository.StudentRepository;
import student.com.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;

	 @Override
	    public Student saveStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    @Override
	    public Student getStudentById(int id) {
	        Optional<Student> studentOptional = studentRepository.findById(id);
	        return studentOptional.orElse(null);
	    }

	    @Override
	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    @Override
	    public void deleteStudent(int id) {
	        studentRepository.deleteById(id);
	    }

	
	
	

}

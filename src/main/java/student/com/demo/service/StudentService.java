package student.com.demo.service;

import java.util.List;

import student.com.demo.model.Student;

public interface StudentService {
    
	public	Student saveStudent(Student student);

	public  Student getStudentById(int id);

	public  List<Student> getAllStudents();

	public void deleteStudent(int id);

	
}

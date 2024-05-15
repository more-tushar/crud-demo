package student.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import student.com.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}

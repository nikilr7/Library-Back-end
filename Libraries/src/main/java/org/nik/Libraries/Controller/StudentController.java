package org.nik.Libraries.Controller;

import java.util.List;

import org.nik.Libraries.HelperClasses.ResponseStructure;
import org.nik.Libraries.Service.StudentService;
import org.nik.Libraries.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins ="http://localhost:5173/")
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/AccountCreation")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student)
	{
		return studentService.saveAdminBooks(student);
	}
	
	@GetMapping("/FindStudentById/{id}")
	public ResponseEntity<ResponseStructure<Student>> findStudentById(@PathVariable Integer id)
	{
		return studentService.FindAdminById(id);
	}
	
	@GetMapping("/FindAllStudent")
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent()
	{
		return studentService.FindAllAdmin();
	}
	
	@PutMapping("/UpdateStudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student)
	{
		return studentService.UpdateAdmin(student);
	}
	
	@DeleteMapping("/DeleteStudent/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteStudent(@PathVariable Integer id)
	{
		return studentService.DeleteAdmin(id);
	}
	
}

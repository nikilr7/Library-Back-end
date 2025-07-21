package org.nik.Libraries.dao;
import java.util.List;
import java.util.Optional;
import org.nik.Libraries.Repository.StudentRepository;
import org.nik.Libraries.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao
{
	@Autowired
	private StudentRepository repository;
	
	
	public Student saveAdmin(Student student)
	{
		return repository.save(student);
	}
	
	
	public Optional<Student> findById(Integer id)
	{
		return repository.findById(id);
	}
	
	
	public List<Student> findAll()
	{
		return repository.findAll();
	}
	
	
	public String deleteAdmin(Student student)
	{
		repository.delete(student);
		return "Deleted"; 
	}
	

}

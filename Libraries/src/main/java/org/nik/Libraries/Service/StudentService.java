package org.nik.Libraries.Service;

import java.util.List;
import java.util.Optional;

import org.nik.Libraries.ExceptionsHandle.IdNotFoundException;
import org.nik.Libraries.HelperClasses.ResponseStructure;
import org.nik.Libraries.dao.StudentDao;
import org.nik.Libraries.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService 
{
	
	@Autowired
	private StudentDao studentDao;
	
	
	public ResponseEntity<ResponseStructure<Student>> saveAdminBooks(Student student)
	{
		Student save=studentDao.saveAdmin(student);
		ResponseStructure<Student> response=new ResponseStructure<Student>();
		
		response.setHttpstatuscode(HttpStatus.CREATED.value());
		response.setData(save);
		response.setMessage("Successfully Saved");
		
		return new ResponseEntity<ResponseStructure<Student>>(response,null,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Student>> FindAdminById(Integer id)
	{
		Optional<Student> findById=studentDao.findById(id);
		
		ResponseStructure<Student> response=new ResponseStructure<Student>();
		
		if(findById.isPresent())
		{
			response.setHttpstatuscode(HttpStatus.ACCEPTED.value());
			response.setData(findById.get());
			response.setMessage("Details Found");
			
			return new ResponseEntity<ResponseStructure<Student>>(response,null,HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> FindAllAdmin()
	{
		List<Student> findAll=studentDao.findAll();
		
		ResponseStructure<List<Student>> response=new ResponseStructure<List<Student>>();
		
		response.setHttpstatuscode(HttpStatus.FOUND.value());
		response.setData(findAll);
		response.setMessage("All Admins Are Assembled");
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(response,null,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Student>> UpdateAdmin(Student student)
	{
		Optional<Student> view=studentDao.findById(student.getId());
		
		if(view.isPresent())
		{
			Student update=studentDao.saveAdmin(student);
			ResponseStructure<Student> response=new ResponseStructure<Student>();
			
			response.setHttpstatuscode(HttpStatus.ACCEPTED.value());
			response.setData(update);
			response.setMessage("Successfully Updated");
			
			return new ResponseEntity<ResponseStructure<Student>>(response,null,HttpStatus.ACCEPTED);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> DeleteAdmin(Integer id)
	{
		Optional<Student> view=studentDao.findById(id);
		
		if(view.isPresent())
		{
			String delete=studentDao.deleteAdmin(view.get());
			ResponseStructure<String> response=new ResponseStructure<String>();
			
			response.setHttpstatuscode(HttpStatus.ACCEPTED.value());
			response.setData(delete);
			response.setMessage("Successfully Deleted");
			
			return new ResponseEntity<ResponseStructure<String>>(response,null,HttpStatus.ACCEPTED);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
}

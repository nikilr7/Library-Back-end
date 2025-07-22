package org.nik.Libraries.Service;

import java.util.List;
import java.util.Optional;

import org.nik.Libraries.ExceptionsHandle.IdNotFoundException;
import org.nik.Libraries.HelperClasses.ResponseStructure;
import org.nik.Libraries.dao.AdminDao;
import org.nik.Libraries.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.nik.Libraries.ExceptionsHandle.MismatchingNotFound;

@Service
public class AdminService 
{
	
	@Autowired
	private AdminDao adminDao;
	
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdminBooks(Admin admin)
	{
		Admin save=adminDao.saveAdmin(admin);
		ResponseStructure<Admin> response=new ResponseStructure<Admin>();
		
		response.setHttpstatuscode(HttpStatus.CREATED.value());
		response.setData(save);
		response.setMessage("Successfully Saved");
		
		return new ResponseEntity<ResponseStructure<Admin>>(response,null,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> FindAdminById(Integer id)
	{
		Optional<Admin> findById=adminDao.findById(id);
		
		ResponseStructure<Admin> response=new ResponseStructure<Admin>();
		
		if(findById.isPresent())
		{
			response.setHttpstatuscode(HttpStatus.ACCEPTED.value());
			response.setData(findById.get());
			response.setMessage("Details Found");
			
			return new ResponseEntity<ResponseStructure<Admin>>(response,null,HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> FindAllAdmin()
	{
		List<Admin> findAll=adminDao.findAll();
		
		ResponseStructure<List<Admin>> response=new ResponseStructure<List<Admin>>();
		
		response.setHttpstatuscode(HttpStatus.OK.value());
		response.setData(findAll);
		response.setMessage("All Admins Are Assembled");
		
		return new ResponseEntity<ResponseStructure<List<Admin>>>(response,null,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> UpdateAdmin(Admin admin)
	{
		Optional<Admin> view=adminDao.findById(admin.getId());
		
		if(view.isPresent())
		{
			Admin update=adminDao.saveAdmin(admin);
			ResponseStructure<Admin> response=new ResponseStructure<Admin>();
			
			response.setHttpstatuscode(HttpStatus.ACCEPTED.value());
			response.setData(update);
			response.setMessage("Successfully Updated");
			
			return new ResponseEntity<ResponseStructure<Admin>>(response,null,HttpStatus.ACCEPTED);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> DeleteAdmin(Integer id)
	{
		Optional<Admin> view=adminDao.findById(id);
		
		if(view.isPresent())
		{
			String delete=adminDao.deleteAdmin(view.get());
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
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminByAdminnameAndPassword (String adminname,String password)
	{
		Optional<Admin> fetch=adminDao.getAdminByAdminnameAndPassword(adminname,password);
		
		ResponseStructure<Admin> response= new ResponseStructure<Admin>();
		
		if(fetch.isPresent())
		{
			response.setData(fetch.get());
			response.setHttpstatuscode(HttpStatus.OK.value());
			response.setMessage("Found");
			return new ResponseEntity<ResponseStructure<Admin>>(response,null,HttpStatus.OK);
		}
		else
		{
			throw new MismatchingNotFound();
		}	
		
	}
}


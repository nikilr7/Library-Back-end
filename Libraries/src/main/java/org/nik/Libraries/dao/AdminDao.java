package org.nik.Libraries.dao;
import java.util.List;
import java.util.Optional;
import org.nik.Libraries.Repository.AdminRepository;
import org.nik.Libraries.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao
{
	@Autowired
	private AdminRepository repository;
	
	
	public Admin saveAdmin(Admin admin)
	{
		return repository.save(admin);
	}
	
	
	public Optional<Admin> findById(Integer id)
	{
		return repository.findById(id);
	}
	
	
	public List<Admin> findAll()
	{
		return repository.findAll();
	}
	
	
	public String deleteAdmin(Admin admin)
	{
		repository.delete(admin);
		return "Deleted"; 
	}
	
	public Optional<Admin> getAdminByAdminnameAndPassword(String adminname,String password)
	{
		 return Optional.of(repository.getAdminByAdminnameAndPassword(adminname, password));
	}
	

}

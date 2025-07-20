package org.nik.Libraries.Controller;

import java.util.List;

import org.nik.Libraries.HelperClasses.ResponseStructure;
import org.nik.Libraries.Service.AdminService;
import org.nik.Libraries.entity.Admin;
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
@RequestMapping("/Admin")
@CrossOrigin(origins ="")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/AddingBooks")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdminBooks(admin);
	}
	
	@GetMapping("/FindAdminById/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@PathVariable Integer id)
	{
		return adminService.FindAdminById(id);
	}
	
	@GetMapping("/FindAllAdmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin()
	{
		return adminService.FindAllAdmin();
	}
	
	@PutMapping("/UpdateAdmin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin)
	{
		return adminService.UpdateAdmin(admin);
	}
	
	@DeleteMapping("/DeleteAdmin/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAdmin(@PathVariable Integer id)
	{
		return adminService.DeleteAdmin(id);
	}
	
}

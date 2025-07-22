package org.nik.Libraries.Repository;

import java.util.Optional;

import org.nik.Libraries.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer>
{
	
	public Admin getAdminByAdminnameAndPassword(String adminname,String password);
}

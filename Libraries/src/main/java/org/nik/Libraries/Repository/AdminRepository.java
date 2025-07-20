package org.nik.Libraries.Repository;

import org.nik.Libraries.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer>
{
	
}

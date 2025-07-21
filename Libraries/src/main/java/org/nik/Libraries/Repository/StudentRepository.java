package org.nik.Libraries.Repository;

import org.nik.Libraries.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
	
}

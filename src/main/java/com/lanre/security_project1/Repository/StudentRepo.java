package com.lanre.security_project1.Repository;

import com.lanre.security_project1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}

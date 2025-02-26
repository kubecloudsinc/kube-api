package com.csrk.userinfo.CSRKSpringApplication.repository;

import com.csrk.userinfo.CSRKSpringApplication.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
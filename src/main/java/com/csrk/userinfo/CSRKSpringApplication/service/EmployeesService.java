package com.csrk.userinfo.CSRKSpringApplication.service;

import com.csrk.userinfo.CSRKSpringApplication.entity.Employees;
import com.csrk.userinfo.CSRKSpringApplication.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees saveEmployee(Employees employee) {
        return employeesRepository.save(employee);
    }

    public Employees updateEmployee(Long id, Employees employeeDetails) {
        Employees employee = employeesRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        employee.setHireDate(employeeDetails.getHireDate());
        employee.setJobId(employeeDetails.getJobId());
        employee.setSalary(employeeDetails.getSalary());
        employee.setCommissionPct(employeeDetails.getCommissionPct());
        employee.setManagerId(employeeDetails.getManagerId());
        employee.setDepartmentId(employeeDetails.getDepartmentId());
        return employeesRepository.save(employee);
    }

    public Page<Employees> getAllEmployees(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }


    public Optional<Employees> getEmployeeById(Long id) {
        return employeesRepository.findById(id);
    }

    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }
}

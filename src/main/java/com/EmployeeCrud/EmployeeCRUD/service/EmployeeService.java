package com.EmployeeCrud.EmployeeCRUD.service;

import com.EmployeeCrud.EmployeeCRUD.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public  String removeEmployee(long id);
    public Optional<Employee> findEmpId(long id);

    public List<Employee> getAllEmployees();
    public String updateEmployee(long id);
}

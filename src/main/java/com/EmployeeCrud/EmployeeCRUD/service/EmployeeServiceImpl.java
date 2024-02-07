package com.EmployeeCrud.EmployeeCRUD.service;

import com.EmployeeCrud.EmployeeCRUD.entity.Employee;
import com.EmployeeCrud.EmployeeCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public String removeEmployee(long id) {
        employeeRepository.deleteById((long) id);
        return "delete records from db";
    }

    @Override
    public Optional<Employee> findEmpId(long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public String updateEmployee(long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            Employee e = new Employee();
            employeeRepository.save(e);
            return "updated successfully";
        }

        else{
            return "Employee not found";
        }

    }
}
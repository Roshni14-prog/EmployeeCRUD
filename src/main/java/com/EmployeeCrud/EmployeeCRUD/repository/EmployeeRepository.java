package com.EmployeeCrud.EmployeeCRUD.repository;

import com.EmployeeCrud.EmployeeCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}

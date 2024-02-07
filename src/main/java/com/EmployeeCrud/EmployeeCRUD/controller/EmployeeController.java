package com.EmployeeCrud.EmployeeCRUD.controller;

import com.EmployeeCrud.EmployeeCRUD.entity.Employee;
import com.EmployeeCrud.EmployeeCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/home")
    public String getMessage(){
        return "This is demo API";
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> emp= employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(emp,HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable long id){
        Optional<Employee> emp=employeeService.findEmpId(id);
        return new ResponseEntity<Optional<Employee>>(emp,HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id){
    employeeService.updateEmployee(id);
    return new ResponseEntity<String>("Updated Successfully",HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        employeeService.removeEmployee(id);
        return  new ResponseEntity<String>("Remove succesfully",HttpStatus.ACCEPTED);
    }

}

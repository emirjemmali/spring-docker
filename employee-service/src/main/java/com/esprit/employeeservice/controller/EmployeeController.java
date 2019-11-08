package com.esprit.employeeservice.controller;

import com.esprit.employeeservice.domain.Employee;
import com.esprit.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
        Employee emp = employeeService.saveEmployee(employee);
        return ResponseEntity.ok().body(emp);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
        Employee emp = employeeService.updateEmployee(employee);
        return ResponseEntity.ok().body(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        ResponseEntity responseEntity;
        Employee employee = employeeService.getEmployeeById(id);
        if (!id.equals(null))

        {
            employeeService.deleteEmployee(employee);

            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.badRequest().body("echec suppression");
        }

        return responseEntity;

    }

    @GetMapping("/{id}")
    ResponseEntity<String> findEmployeeById(@PathVariable("id") String id) {

        if (!id.equals(null)) {
            Employee employee=employeeService.getEmployeeById(id);
            return new ResponseEntity<>(
                "your employee is: " + employee,
                HttpStatus.OK);
        }

        return new ResponseEntity<>(
            "there's no employee ",
            HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/email")
    ResponseEntity<String> findEmployeeByEmail(@RequestParam String email) {

        if (!email.equals(null)){
            Employee employee=employeeService.getEmployeeByEmail(email);
            return new ResponseEntity<>(
                "your employee is: " + employee,
                HttpStatus.OK);
        }

        return new ResponseEntity<>(
            "there's no employee ",
            HttpStatus.BAD_REQUEST);

    }

    @GetMapping()
    ResponseEntity<String> findAllEmployees() {

            List<Employee> employees = employeeService.getAllEmployees();
            if (!employees.isEmpty()) {
                return new ResponseEntity<>(
                    "employees are: " + employees,
                    HttpStatus.OK);
            }

        return new ResponseEntity<>(
            "there's no employee ",
            HttpStatus.BAD_REQUEST);

    }




}

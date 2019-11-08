package com.esprit.employeeservice.service;

import com.esprit.employeeservice.domain.Employee;
import com.esprit.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteById(employee.getId());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {

        Employee employee= employeeRepository.findById(id).get();
        if(!employee.equals(null)) {
            return employee;
        }
        return null;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {

        Employee employee= employeeRepository.findEmployeeByEmail(email);
        if(!employee.equals(null)){
            return employee;
        }
        return null;
    }


}

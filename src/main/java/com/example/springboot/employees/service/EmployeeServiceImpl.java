package com.example.springboot.employees.service;

import com.example.springboot.employees.dao.EmployeeRepository;
import com.example.springboot.employees.entity.Employee;
import com.example.springboot.employees.exception.EmployeeNotFoundException;
import com.example.springboot.employees.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        // Check if there is an existing employee with the id, throw EmployeeNotFoundException if none is found
        return handleFindById(id);
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        Employee employee = convertToEmployee(0, employeeRequest);
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        // Check if there is an existing employee with the id, throw EmployeeNotFoundException if none is found
        handleFindById(id);

        Employee employee = convertToEmployee(id, employeeRequest);
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        // Check if there is an existing employee with the id, throw EmployeeNotFoundException if none is found
        handleFindById(id);

        employeeRepository.deleteById(id);
    }

    private Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(
                id,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail()
        );
    }

    private Employee handleFindById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee with an id of %d is not found".formatted(id)
                ));
    }
}

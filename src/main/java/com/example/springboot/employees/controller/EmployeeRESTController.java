package com.example.springboot.employees.controller;

import com.example.springboot.employees.entity.Employee;
import com.example.springboot.employees.request.EmployeeRequest;
import com.example.springboot.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Employee Rest API Endpoints", description="Operations related to employees")
@RestController
@RequestMapping("/api/employees")
public class EmployeeRESTController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get all employees", description = "Retrieve all available employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @Operation(summary = "Get an employee by id", description = "Retrieve an available employee by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable @Min(value=1) long employeeId) {
        return employeeService.findById(employeeId);
    }

    @Operation(summary = "Add a new employee", description = "Create and register a new employee")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        employeeService.save(employeeRequest);
    }

    @Operation(summary = "Update an employee by id", description = "Update an existing employee by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{employeeId}")
    public void updateEmployee(
            @PathVariable @Min(value=1) long employeeId,
            @Valid @RequestBody EmployeeRequest employeeRequest
    ) {
        employeeService.update(employeeId, employeeRequest);
    }

    @Operation(summary = "Delete an employee by id", description = "Delete an existing employee by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable @Min(value=1) long employeeId) {
        employeeService.deleteById(employeeId);
    }
}

package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.model.ViewEmployee;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<ViewEmployee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        ViewEmployee savedEmployee = service.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<ViewEmployee> getEmployeeById(@RequestBody Long id) {
        ViewEmployee employee = service.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("getAllEmployee")
    public ResponseEntity<List<ViewEmployee>> getEmployeeList() {
        List<ViewEmployee> employeeList = service.getEmplooEmployeeList();
        return ResponseEntity.ok(employeeList);
    }

    @PutMapping
    public ResponseEntity<ViewEmployee> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        ViewEmployee updateEmployee = service.updateEmployee(employeeDto);
        return ResponseEntity.ok(updateEmployee);
    }


}

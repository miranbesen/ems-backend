package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
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
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmp = service.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestBody Long id) {
        EmployeeDto employee = service.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getEmployeeList() {
        List<EmployeeDto> employeeList = service.getEmplooEmployeeList();
        return ResponseEntity.ok(employeeList);
    }

}

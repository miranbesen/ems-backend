package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getEmplooEmployeeList();
}

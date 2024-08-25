package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.model.ViewEmployee;

import java.util.List;

public interface IEmployeeService {
    ViewEmployee createEmployee(EmployeeDto employeeDto);

    ViewEmployee getEmployeeById(Long id);

    List<ViewEmployee> getEmplooEmployeeList();

    ViewEmployee updateEmployee(EmployeeDto employeeDto);
}

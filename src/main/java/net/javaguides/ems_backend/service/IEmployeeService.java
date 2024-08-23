package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;

public interface IEmployeeService {
    Employee createEmployee(EmployeeDto employeeDto);
}

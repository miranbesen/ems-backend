package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(EmployeeDto employeeDto);

    Employee update(Long id, EmployeeDto employeeDto);

    String delete(Long id);

    Employee getById(Long id);

    List<Employee> getAll();
}

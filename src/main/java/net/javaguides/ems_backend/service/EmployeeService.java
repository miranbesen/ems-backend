package net.javaguides.ems_backend.service;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.exception.ResourceNotFoundException;
import net.javaguides.ems_backend.model.ViewEmployee;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository repository;

    @Override
    public ViewEmployee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        return new ViewEmployee(repository.save(employee));
    }

    @Override
    public ViewEmployee getEmployeeById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " + id));
        return new ViewEmployee(employee);
    }

    @Override
    public List<ViewEmployee> getEmplooEmployeeList() {
        List<Employee> employeeList = repository.findAll();
        return employeeList.stream().map(ViewEmployee::new).collect(Collectors.toList());
    }

    @Override
    public ViewEmployee updateEmployee(EmployeeDto employeeDto) {
        Employee employee = repository.findById(employeeDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeDto.getId()));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        return new ViewEmployee(repository.save(employee));
    }


}

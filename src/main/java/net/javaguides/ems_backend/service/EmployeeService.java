package net.javaguides.ems_backend.service;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.exception.ResourceNotFoundException;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository repository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        return new EmployeeDto(repository.save(employee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " + id));
        return new EmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmplooEmployeeList() {
        List<Employee> employeeList = repository.findAll();
        return employeeList.stream().map(EmployeeDto::new).collect(Collectors.toList());
    }
}

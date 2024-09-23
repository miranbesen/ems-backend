package net.javaguides.ems_backend.service;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee create(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        Employee saveEmp = employeeRepository.save(employee);
        return saveEmp;
    }

    @Override
    public Employee update(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.getById(id);
        if (Objects.nonNull(employee)) {
            employee.builder().firstName(employee.getFirstName()).lastName(employee.getLastName()).email(employeeDto.getEmail()).build();
        }
        return employeeRepository.save(employee);
    }

    @Override
    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return "deleted successfully";
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}

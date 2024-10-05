package net.javaguides.ems_backend.service;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.core.utilities.result.ResourceNotFoundException;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee create(EmployeeDto employeeDto) {
        Employee employee = Employee.builder().firstName(employeeDto.getFirstName()).lastName(employeeDto.getLastName()).email(employeeDto.getEmail()).build();
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, EmployeeDto employeeDto) {
        Employee employee = this.getById(id);

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        return this.save(employee);
    }

    @Override
    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return "deleted successfully";
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}

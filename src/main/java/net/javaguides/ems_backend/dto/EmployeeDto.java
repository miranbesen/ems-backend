package net.javaguides.ems_backend.dto;

import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javaguides.ems_backend.entity.Employee;
import org.springframework.beans.BeanUtils;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDto(Employee employee) {
        BeanUtils.copyProperties(employee, this);
    }
}

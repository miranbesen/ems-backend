package net.javaguides.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import org.springframework.beans.BeanUtils;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    public Employee(EmployeeDto employeeDto){
        BeanUtils.copyProperties(employeeDto,this);
    }
}

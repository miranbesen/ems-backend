package net.javaguides.ems_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javaguides.ems_backend.entity.Employee;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewEmployee {
    private String firstName;
    private String lastName;
    private String email;

    public ViewEmployee(Employee employee){
        BeanUtils.copyProperties(employee,this);
    }
}

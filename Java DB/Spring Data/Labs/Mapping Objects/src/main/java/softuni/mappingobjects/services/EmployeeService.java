package softuni.mappingobjects.services;

import softuni.mappingobjects.entities.Employee;
import softuni.mappingobjects.dto.EmployeeDTO;

public interface EmployeeService {
    Employee create(EmployeeDTO employeeDTO);
}

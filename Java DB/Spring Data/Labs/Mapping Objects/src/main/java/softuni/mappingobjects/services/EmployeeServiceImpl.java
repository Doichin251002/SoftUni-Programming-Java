package softuni.mappingobjects.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.mappingobjects.dto.EmployeeDTO;
import softuni.mappingobjects.entities.Employee;
import softuni.mappingobjects.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(EmployeeDTO employeeDTO) {
        ModelMapper mapper = new ModelMapper();

        Employee employee = mapper.map(employeeDTO, Employee.class);

        return repository.save(employee);
    }
}

package softuni.mappingobjects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.mappingobjects.dto.AddressDTO;
import softuni.mappingobjects.dto.EmployeeDTO;
import softuni.mappingobjects.entities.Address;
import softuni.mappingobjects.entities.Employee;
import softuni.mappingobjects.services.AddressService;
import softuni.mappingobjects.services.EmployeeService;

import java.util.Scanner;

@Component
public class ControlRunner implements CommandLineRunner {
    private final AddressService addressService;
    private final EmployeeService employeeService;

    public ControlRunner(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        enterAddress(scanner);

        enterEmployee(scanner);

        System.out.println("Works!");
    }

    private void enterEmployee(Scanner scanner) {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter salary: ");
        String salary = scanner.nextLine();

        EmployeeDTO employeeDTO = new EmployeeDTO(firstName, lastName, salary);
        employeeService.create(employeeDTO);
    }

    private void enterAddress(Scanner scanner) {
        System.out.println("Enter country: ");
        String country = scanner.nextLine();

        System.out.println("Enter town: ");
        String town = scanner.nextLine();

        AddressDTO addressDTO = new AddressDTO(country, town);
        addressService.create(addressDTO);
    }
}

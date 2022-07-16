package pro.sky.homework2_6.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_6.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework2_6.Exceptions.EmployeeNotFoundException;
import pro.sky.homework2_6.Exceptions.EmployeeStorageIsFullException;

import java.util.Objects;

@Service
public class EmployeeService {

    private Employee[] staff = {
            new Employee("Кот", "Федя"),
            new Employee("Кот", "Тимофей"),
            new Employee("Кот", "Барсик"),
            new Employee("Кошка", "Даша"),
            new Employee("Кошка", "Клёпа"),
            new Employee("Кошка", "Багира"),
            new Employee("Кошка", "Люся"),
            new Employee("Кот Марк", "Шагал"),
            new Employee("Кот", "Джек"),
            new Employee("Кошка", "Джинни")
    };


    public Employee addEmployee(String name, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, lastName);
        for (int i = 0; i < staff.length; i++) {
            if (Objects.isNull(staff[i])){
                staff[i] = employee;
            } else if (staff[i].getName().equals(name) && staff[i].getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Employee is already added");
            } else {
                throw new EmployeeStorageIsFullException("Employee storage is full");
            }
        }
        return employee;
    }

    public Employee deleteEmployee(String name, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName);
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getName().equals(name) && staff[i].getLastName().equals(lastName)){
                staff[i] = null;
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee is not found");
    }

    public Employee searchEmployee(String name, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName);
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getName().equals(name) && staff[i].getLastName().equals(lastName)){
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee is not found");
    }

}

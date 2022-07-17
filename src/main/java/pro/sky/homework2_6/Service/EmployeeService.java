package pro.sky.homework2_6.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_6.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework2_6.Exceptions.EmployeeNotFoundException;
import pro.sky.homework2_6.Exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {

    private List <Employee> staff = new ArrayList<> (Arrays.asList(
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
    ));


    public Employee addEmployee(String name, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, lastName);
        int index = -1;
        for (int i = 0; i < staff.size(); i++) {
            if (Objects.isNull(staff.get(i))) {
                index = i;
                break;
            } else if (Objects.equals(staff.get(i), employee)) {
                throw new EmployeeAlreadyAddedException("Employee is already added");
            }
        }
        if (index != -1) {
            staff.set(index, employee);
        } else {
            throw new EmployeeStorageIsFullException("Employee storage is full");
        }
        return employee;
    }

    public Employee deleteEmployee(String name, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName);
        for (int i = 0; i < staff.size(); i++) {
            if (Objects.equals(staff.get(i), employee)){
                staff.remove(i);
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee is not found");
    }

    public Employee searchEmployee(String name, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName);
        for (int i = 0; i < staff.size(); i++) {
            if (Objects.equals(staff.get(i), employee)){
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee is not found");
    }

    public List<Employee> staffList() {
        return new ArrayList<>(staff);
    }

}

package pro.sky.homework2_6.Controller;

import org.springframework.http.MediaType;
import pro.sky.homework2_6.Service.Employee;
import pro.sky.homework2_6.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee add(@RequestParam("firstName") String name,
                        @RequestParam("lastName") String lastName) {
        if (Objects.isNull(name) || Objects.isNull(lastName)) {
            System.out.println("Неправильно переданы параметры!");
        }
        return employeeService.addEmployee(name, lastName);
    }

    @GetMapping(value = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee remove(@RequestParam("firstName") String name,
                        @RequestParam("lastName") String lastName) {
        if (Objects.isNull(name) || Objects.isNull(lastName)) {
            System.out.println("Неправильно переданы параметры!");
        }
        return employeeService.deleteEmployee(name, lastName);
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee find(@RequestParam("firstName") String name,
                           @RequestParam("lastName") String lastName) {
        if (Objects.isNull(name) || Objects.isNull(lastName)) {
            System.out.println("Неправильно переданы параметры!");
        }
        return employeeService.searchEmployee(name, lastName);
    }
}

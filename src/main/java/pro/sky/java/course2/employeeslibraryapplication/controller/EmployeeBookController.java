package pro.sky.java.course2.employeeslibraryapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeeslibraryapplication.data.Employee;
import pro.sky.java.course2.employeeslibraryapplication.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeeslibraryapplication.exception.IllegalSymbolException;
import pro.sky.java.course2.employeeslibraryapplication.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmployeeBookController {
    private final EmployeeService employeeService;

    public EmployeeBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String surname,
                                @RequestParam String name,
                                @RequestParam String middleName,
                                @RequestParam int department,
                                @RequestParam int salary) {
        return employeeService.addEmployee(surname, name, middleName, department, salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String surname,
                                 @RequestParam String name,
                                 @RequestParam String middleName) throws EmployeeNotFoundException {
        return "Сотрудник " + employeeService.removeEmployee(surname, name, middleName) + " удалён.";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String surname,
                                 @RequestParam String name,
                                 @RequestParam String middleName) throws EmployeeNotFoundException {
        return employeeService.findEmployee(surname, name, middleName);
    }

    @GetMapping("/check")
    public String checkName(@RequestParam String surname,
                            @RequestParam String name,
                            @RequestParam String middleName) throws IllegalSymbolException {
        return "Сотрудник " + employeeService.checkName(surname, name, middleName) + " записан правильно.";

    }
}
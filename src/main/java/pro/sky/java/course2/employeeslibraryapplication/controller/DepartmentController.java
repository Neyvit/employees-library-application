package pro.sky.java.course2.employeeslibraryapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeeslibraryapplication.data.Employee;
import pro.sky.java.course2.employeeslibraryapplication.service.DepartmentService;

import java.util.Collection;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam int department) {
        return departmentService.getMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam int department) {
        return departmentService.getMinimumSalary(department);
    }

    @GetMapping("/all")
    public Collection<Employee> getAllEmployees(Integer department) {
        return departmentService.getDepartmentEmployee(department);
    }
}

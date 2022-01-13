package pro.sky.java.course2.employeeslibraryapplication.service;


import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeslibraryapplication.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getDepartmentEmployee(Integer department) {
        Stream<Employee> employeeStream = employeeService.getAllEmployees().stream();
        if (department != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartment() == department);
        }
        return employeeStream.sorted(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getMiddleName)
        ).collect(Collectors.toList());
    }

    public Employee getMaxSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinimumSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }
}

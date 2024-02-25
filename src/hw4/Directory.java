package hw4;

import java.awt.image.ReplicateScaleFilter;
import java.time.LocalDate;
import java.util.List;

public class Directory {

    private List<Employee> employees;

    public Directory(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findByExperience(int year) {
        return employees.stream()
                .filter(employee -> year <= (LocalDate.now().getYear() - employee.getExperience().getYear()))
                .toList();
    }

    public String findTelephoneNumberByName(String name) {
        return employees.stream()
                .filter(employee -> name.equals(employee.getName()))
                .map(Employee::getTelephoneNumber)
                .findFirst()
                .orElse("Employee with name " + name + " doesn't exist.");
    }

    public Employee findEmployeeByPersonnelNumber(int number) {
        return employees.stream()
                .filter(employee -> number == employee.getPersonnelNumber())
                .findFirst().get();
    }
}

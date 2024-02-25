package hw4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int persNumber = 1;
        List<Employee> employees = new ArrayList<>();
        employees.add(
                new Employee("Batman", persNumber++, LocalDate.of(2000,5,20), "4652165"));
        employees.add(
                new Employee("Superman", persNumber++, LocalDate.of(1990,4,2), "4411561"));
        employees.add(
                new Employee("Spider-man", persNumber++, LocalDate.of(2012,5,7), "4656564156"));
        employees.add(
                new Employee("Green Lantern", persNumber++, LocalDate.of(1995,8,14), "4656456"));

        Directory directory = new Directory(employees);

        directory.addEmployee(
                new Employee("Iron Man", persNumber++, LocalDate.now(), "4841568"));
        System.out.println(directory.getEmployees());
        System.out.println(directory.findEmployeeByPersonnelNumber(3));
        System.out.println(directory.findTelephoneNumberByName("Iron Man"));
        System.out.println(directory.findByExperience(15));
    }
}

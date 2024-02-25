package hw4;

import java.time.LocalDate;

public class Employee {
    private String name;
    private int personnelNumber;
    private LocalDate experience;
    private String telephoneNumber;

    public Employee(String name, int personnelNumber, LocalDate experience, String telephoneNumber) {
        this.name = name;
        this.personnelNumber = personnelNumber;
        this.experience = experience;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(int personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public LocalDate getExperience() {
        return experience;
    }

    public void setExperience(LocalDate experience) {
        this.experience = experience;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}

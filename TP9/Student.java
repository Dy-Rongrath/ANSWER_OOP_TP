package TP9;

import java.util.Scanner;

public class Student {
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String city;
    private String country;
    private String group;

    // Method for data input (read from keyboard and fill in the fields)
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter date of birth: ");
        dateOfBirth = scanner.nextLine();
        System.out.print("Enter telephone number: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Enter city: ");
        city = scanner.nextLine();
        System.out.print("Enter country: ");
        country = scanner.nextLine();
        System.out.print("Enter group: ");
        group = scanner.nextLine();
    }

    // Method for data output
    public void outputData() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Telephone Number: " + phoneNumber);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
        System.out.println("Group: " + group);
    }

    // Accessors
    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getGroup() {
        return group;
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    // Example usage
    public static void main(String[] args) {
        Student student = new Student();
        student.inputData();

        System.out.println("\nStudent Information:");
        student.outputData();
    }
}

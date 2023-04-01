import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("1. Add new student");
            System.out.println("2. List students");
            System.out.println("3. Remove student by name");
            System.out.println("4. Update student information by id");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    listStudents();
                    break;
                case 3:
                    removeStudentByName(scanner);
                    break;
                case 4:
                    updateStudentInfoById(scanner);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        }
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();
        System.out.print("Enter student GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();
        Student student = new Student(id, name, major, gpa);
        students.add(student);
        System.out.println("Student added.");
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void removeStudentByName(Scanner scanner) {
        System.out.print("Enter student name to remove: ");
        String name = scanner.nextLine();
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equals(name)) {
                students.remove(i);
                System.out.println("Student removed.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("No student with name " + name + " found.");
        }
    }

    private static void updateStudentInfoById(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToUpdate = student;
                break;
            }
        }
        if (studentToUpdate == null) {
            System.out.println("No student with ID " + id + " found.");
        } else {
            System.out.print("Enter student name (current name: " + studentToUpdate.getName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter student major (current major: " + studentToUpdate.getMajor() + "): ");
            String major = scanner.nextLine();
            System.out.print("Enter student GPA (current GPA: " + studentToUpdate.getGpa() + "): ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            studentToUpdate.setName(name);
            studentToUpdate.setMajor(major);
            studentToUpdate.setGpa(gpa);
            System.out.println("Student information updated.");
        }
    }
}
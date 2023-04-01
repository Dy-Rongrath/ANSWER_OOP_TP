import java.util.ArrayList;
import java.util.Scanner;

public class CourseProgram {
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. List all courses");
            System.out.println("2. Find courses by name");
            System.out.println("3. Add new course");
            System.out.println("4. Quit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllCourses();
                    break;
                case 2:
                    findCoursesByName();
                    break;
                case 3:
                    addNewCourse();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void listAllCourses() {
        System.out.println("List of all courses:");

        for (Course course : courses) {
            System.out.println(course.getName() + " (" + course.getCode() + "), " + course.getCredit() + " credits");
        }
    }

    private static void findCoursesByName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String name = scanner.nextLine();

        System.out.println("Courses with name \"" + name + "\":");

        for (Course course : courses) {
            if (course.getName().equals(name)) {
                System.out
                        .println(course.getName() + " (" + course.getCode() + "), " + course.getCredit() + " credits");
            }
        }
    }

    private static void addNewCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String name = scanner.nextLine();

        System.out.print("Enter course code: ");
        String code = scanner.nextLine();

        System.out.print("Enter course credit: ");
        int credit = scanner.nextInt();

        courses.add(new Course(name, code, credit));
        System.out.println("Course added successfully!");
    }
}

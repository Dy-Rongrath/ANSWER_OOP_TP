package TP9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private String studentId;
    private List<Book> borrowedBooks;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getNumberOfBooksBorrowed() {
        return borrowedBooks.size();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public Book returnBook(String isbn) {
        for (Book book : borrowedBooks) {
            if (book.getIsbn().equals(isbn)) {
                borrowedBooks.remove(book);
                return book;
            }
        }
        return null;
    }

    public void displayBorrowedBooks() {
        for (Book book : borrowedBooks) {
            book.displayBookInformation();
            System.out.println();
        }
    }
}

class Book {
    private String title;
    private String description;
    private String category;
    private String isbn;
    private String author;
    private int publishedYear;
    private int inventoryCount;
    private boolean availableForBorrow;

    public Book(String title, String description, String category, String isbn, String author,
            int publishedYear, int inventoryCount) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.isbn = isbn;
        this.author = author;
        this.publishedYear = publishedYear;
        this.inventoryCount = inventoryCount;
        this.availableForBorrow = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public boolean isAvailableForBorrow() {
        return availableForBorrow;
    }

    public void decreaseInventoryCount() {
        if (inventoryCount > 0) {
            inventoryCount--;
        }
    }

    public void increaseInventoryCount() {
        inventoryCount++;
    }

    public void setAvailableForBorrow(boolean availableForBorrow) {
        this.availableForBorrow = availableForBorrow;
    }

    public void displayBookInformation() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("ISBN: " + isbn);
        System.out.println("Author: " + author);
        System.out.println("Published Year: " + publishedYear);
        System.out.println("Inventory Count: " + inventoryCount);
        System.out.println("Available for Borrow: " + availableForBorrow);
    }

    public static Book createNewBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the category: ");
        String category = scanner.nextLine();
        System.out.print("Enter the ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the published year: ");
        int publishedYear = scanner.nextInt();
        System.out.print("Enter the inventory count: ");
        int inventoryCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        return new Book(title, description, category, isbn, author, publishedYear, inventoryCount);
    }
}

class Category {
    private String name;
    private String description;
    private List<Book> books;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void listAllBooks() {
        System.out.println("Books in the category: " + name);
        for (Book book : books) {
            book.displayBookInformation();
            System.out.println();
        }
    }

    public static Category createNewCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the category description: ");
        String description = scanner.nextLine();
        return new Category(name, description);
    }
}

class Library {
    private Map<String, Category> categories;
    private List<Student> students;

    public Library() {
        categories = new HashMap<>();
        students = new ArrayList<>();
    }

    public void listAllCategories() {
        System.out.println("Categories in the library:");
        for (Category category : categories.values()) {
            System.out.println(category.getName() + " - " + category.getDescription());
        }
    }

    public void listBooksByCategory(String categoryName) {
        Category category = categories.get(categoryName);
        if (category != null) {
            category.listAllBooks();
        } else {
            System.out.println("Category not found.");
        }
    }

    public void listBooksByYear(int year) {
        System.out.println("Books published in " + year + ":");
        for (Category category : categories.values()) {
            for (Book book : category.getBooks()) {
                if (book.getPublishedYear() == year) {
                    book.displayBookInformation();
                    System.out.println();
                }
            }
        }
    }

    public void listAvailableBooks() {
        System.out.println("Available books:");
        for (Category category : categories.values()) {
            for (Book book : category.getBooks()) {
                if (book.isAvailableForBorrow()) {
                    book.displayBookInformation();
                    System.out.println();
                }
            }
        }
    }

    public void addNewBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category name for the new book: ");
        String categoryName = scanner.nextLine();
        Category category = categories.get(categoryName);
        if (category != null) {
            Book book = Book.createNewBook();
            category.addBook(book);
            System.out.println("New book added successfully.");
        } else {
            System.out.println("Category not found. Cannot add new book.");
        }
    }

    public void decreaseBookByISBN(String isbn) {
        for (Category category : categories.values()) {
            Book book = category.findBookByISBN(isbn);
            if (book != null) {
                book.decreaseInventoryCount();
                System.out.println("Inventory count decreased successfully.");
                return;
            }
        }
        System.out.println("Book not found. Cannot decrease inventory count.");
    }

    public void removeBookByISBN(String isbn) {
        for (Category category : categories.values()) {
            Book book = category.findBookByISBN(isbn);
            if (book != null) {
                category.removeBook(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found. Cannot remove book.");
    }

    public void addNewCopiesOfBook(String isbn, int count) {
        for (Category category : categories.values()) {
            Book book = category.findBookByISBN(isbn);
            if (book != null) {
                book.increaseInventoryCount();
                System.out.println("Additional copies added successfully.");
                return;
            }
        }
        System.out.println("Book not found. Cannot add additional copies.");
    }

    public void markBookNotAvailable(String isbn) {
        for (Category category : categories.values()) {
            Book book = category.findBookByISBN(isbn);
            if (book != null) {
                book.setAvailableForBorrow(false);
                System.out.println("Book marked as not available for borrow.");
                return;
            }
        }
        System.out.println("Book not found. Cannot mark as not available for borrow.");
    }

    public void serveStudent(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student: " + student.getName());
        System.out.println("Borrowed Books:");
        student.displayBorrowedBooks();

        System.out.println("Enter the ISBN of the book to borrow (or 0 to exit):");
        String isbn = scanner.nextLine();
        while (!isbn.equals("0")) {
            Category category = findCategoryContainingBook(isbn);
            if (category != null) {
                Book book = category.findBookByISBN(isbn);
                if (book != null && book.isAvailableForBorrow()) {
                    if (student.getNumberOfBooksBorrowed() < 5) {
                        student.borrowBook(book);
                        book.setAvailableForBorrow(false);
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("You have already borrowed the maximum number of books.");
                    }
                } else {
                    System.out.println("Book not available for borrow.");
                }
            } else {
                System.out.println("Book not found.");
            }

            System.out.println("Enter the ISBN of the book to borrow (or 0 to exit):");
            isbn = scanner.nextLine();
        }
    }

    public void returnBook(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student: " + student.getName());
        System.out.println("Borrowed Books:");
        student.displayBorrowedBooks();

        System.out.println("Enter the ISBN of the book to return (or 0 to exit):");
        String isbn = scanner.nextLine();
        while (!isbn.equals("0")) {
            Book returnedBook = student.returnBook(isbn);
            if (returnedBook != null) {
                Category category = findCategoryContainingBook(isbn);
                if (category != null) {
                    Book book = category.findBookByISBN(isbn);
                    if (book != null) {
                        book.setAvailableForBorrow(true);
                        System.out.println("Book returned successfully.");
                    }
                }
            } else {
                System.out.println("Book not found in your borrowed books.");
            }

            System.out.println("Enter the ISBN of the book to return (or 0 to exit):");
            isbn = scanner.nextLine();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void listStudents() {
        System.out.println("Students who borrowed books:");
        for (Student student : students) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Number of Books Borrowed: " + student.getNumberOfBooksBorrowed());
            System.out.println();
        }
    }

    private Category findCategoryContainingBook(String isbn) {
        for (Category category : categories.values()) {
            if (category.findBookByISBN(isbn) != null) {
                return category;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("GIC Library");
            System.out.println("1. List all categories");
            System.out.println("2. List books by category");
            System.out.println("3. List books by year");
            System.out.println("4. List available books");
            System.out.println("5. Add new book");
            System.out.println("6. Decrease book by ISBN");
            System.out.println("7. Remove book by ISBN");
            System.out.println("8. Add new copies of book");
            System.out.println("9. Mark book not available to borrow");
            System.out.println("10. Let student borrow book");
            System.out.println("11. List students that borrowed books");
            System.out.println("12. Let student return book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    library.listAllCategories();
                    break;
                case 2:
                    System.out.print("Enter the category name: ");
                    String categoryName = scanner.nextLine();
                    library.listBooksByCategory(categoryName);
                    break;
                case 3:
                    System.out.print("Enter the year: ");
                    int year = scanner.nextInt();
                    library.listBooksByYear(year);
                    break;
                case 4:
                    library.listAvailableBooks();
                    break;
                case 5:
                    library.addNewBook();
                    break;
                case 6:
                    System.out.print("Enter the ISBN: ");
                    String isbn = scanner.nextLine();
                    library.decreaseBookByISBN(isbn);
                    break;
                case 7:
                    System.out.print("Enter the ISBN: ");
                    isbn = scanner.nextLine();
                    library.removeBookByISBN(isbn);
                    break;
                case 8:
                    System.out.print("Enter the ISBN: ");
                    isbn = scanner.nextLine();
                    System.out.print("Enter the number of copies to add: ");
                    int count = scanner.nextInt();
                    library.addNewCopiesOfBook(isbn, count);
                    break;
                case 9:
                    System.out.print("Enter the ISBN: ");
                    isbn = scanner.nextLine();
                    library.markBookNotAvailable(isbn);
                    break;
                case 10:
                    System.out.print("Enter the student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter the student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = new Student(studentName, studentId);
                    library.addStudent(student);
                    library.serveStudent(student);
                    break;
                case 11:
                    library.listStudents();
                    break;
                case 12:
                    System.out.print("Enter the student name: ");
                    studentName = scanner.nextLine();
                    System.out.print("Enter the student ID: ");
                    studentId = scanner.nextLine();
                    student = new Student(studentName, studentId);
                    library.returnBook(student);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        System.out.println("Thank you for using the GIC Library.");
    }
}

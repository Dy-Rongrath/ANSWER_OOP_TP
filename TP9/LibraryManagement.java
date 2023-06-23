package TP9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in this category.");
        } else {
            System.out.println("Books in Category: " + name);
            for (Book book : books) {
                book.displayBookInformation();
                System.out.println();
            }
        }
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public int countBooks() {
        return books.size();
    }

    public static Category createNewCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the category: ");
        String name = scanner.nextLine();
        System.out.print("Enter the description of the category: ");
        String description = scanner.nextLine();

        return new Category(name, description);
    }

    public void addRemoveBooksInCategory() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAdd/Remove Books in Category: " + name);
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Book book = Book.createNewBook();
                    addBook(book);
                    System.out.println("Book added to the category.");
                    break;
                case 2:
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String isbn = scanner.nextLine();
                    Book foundBook = findBookByISBN(isbn);
                    if (foundBook != null) {
                        removeBook(foundBook);
                        System.out.println("Book removed from the category.");
                    } else {
                        System.out.println("Book not found in the category.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting add/remove books menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 0);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Category category = Category.createNewCategory();
        category.addRemoveBooksInCategory();

        System.out.println("\nCategory Information:");
        System.out.println("Name: " + category.getName());
        System.out.println("Description: " + category.getDescription());
        System.out.println("Book Count: " + category.countBooks());
        category.listAllBooks();
    }
}

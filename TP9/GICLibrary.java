package TP9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String description;
    private String category;
    private String isbn;
    private List<String> authors;
    private LocalDate publishedDate;
    private int inventoryCount;

    public Book(String title, String description, String category, String isbn,
            List<String> authors, LocalDate publishedDate, int inventoryCount) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.isbn = isbn;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.inventoryCount = inventoryCount;
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

    public List<String> getAuthors() {
        return authors;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void decreaseInventoryCount() {
        if (inventoryCount > 0) {
            inventoryCount--;
        }
    }

    public void increaseInventoryCount() {
        inventoryCount++;
    }

    public boolean isAvailableForBorrow() {
        return inventoryCount > 0;
    }

    public void displayBookInformation() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("ISBN: " + isbn);
        System.out.println("Authors: " + authors);
        System.out.println("Published Date: " + publishedDate);
        System.out.println("Inventory Count: " + inventoryCount);
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
        List<String> authors = new ArrayList<>();
        System.out.print("Enter the author(s) (comma-separated): ");
        String authorsInput = scanner.nextLine();
        String[] authorNames = authorsInput.split(",");
        for (String authorName : authorNames) {
            authors.add(authorName.trim());
        }
        System.out.print("Enter the published date (YYYY-MM-DD): ");
        String publishedDateInput = scanner.nextLine();
        LocalDate publishedDate = LocalDate.parse(publishedDateInput);
        System.out.print("Enter the inventory count: ");
        int inventoryCount = scanner.nextInt();

        return new Book(title, description, category, isbn, authors, publishedDate, inventoryCount);
    }
}

public class GICLibrary {
    public static void main(String[] args) {
        // Test the Book class
        Book book = Book.createNewBook();
        System.out.println("\nBook Information:");
        book.displayBookInformation();
    }
}

package TP9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int productNumber;
    private String name;
    private double price;
    private int stock;

    public Product(int productNumber, String name, double price, int stock) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}

public class GiftShopManager {
    private List<Product> products;

    public GiftShopManager() {
        products = new ArrayList<>();
    }

    public void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product Number\tName\tPrice\tStock");
            for (Product product : products) {
                System.out.println(product.getProductNumber() + "\t" + product.getName() + "\t" +
                        product.getPrice() + "\t" + product.getStock());
            }
        }
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product number: ");
        int productNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product stock: ");
        int stock = scanner.nextInt();

        Product product = new Product(productNumber, name, price, stock);
        products.add(product);

        System.out.println("Product added successfully.");
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the product to remove: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < products.size()) {
            products.remove(index);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Invalid index. Product not found.");
        }
    }

    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the product to update: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < products.size()) {
            Product product = products.get(index);
            System.out.print("Enter new product number: ");
            int productNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new product price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter new product stock: ");
            int stock = scanner.nextInt();

            product = new Product(productNumber, name, price, stock);
            products.set(index, product);

            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Invalid index. Product not found.");
        }
    }

    public void serveCustomer() {
        // Cashier menu implementation
        // ...
    }

    public void closeShop() {
        double revenue = 0;
        for (Product product : products) {
            revenue += (product.getPrice() * product.getStock());
        }
        System.out.println("Total revenue for today: " + revenue);
    }

    public static void main(String[] args) {
        GiftShopManager shopManager = new GiftShopManager();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. List all products");
            System.out.println("2. Add new product");
            System.out.println("3. Remove product");
            System.out.println("4. Update product");
            System.out.println("5. Serve a customer");
            System.out.println("6. Close today's shop");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shopManager.listAllProducts();
                    break;
                case 2:
                    shopManager.addProduct();
                    break;
                case 3:
                    shopManager.removeProduct();
                    break;
                case 4:
                    shopManager.updateProduct();
                    break;
                case 5:
                    shopManager.serveCustomer();
                    break;
                case 6:
                    shopManager.closeShop();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 0);
    }
}

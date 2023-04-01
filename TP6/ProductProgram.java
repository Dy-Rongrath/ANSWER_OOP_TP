import java.util.ArrayList;
import java.util.Scanner;

public class ProductProgram {
    private static ArrayList<Product> products = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. List all products");
            System.out.println("2. Add new product");
            System.out.println("3. Remove product by index");
            System.out.println("4. Update product");
            System.out.println("5. Quit");
            System.out.print("Enter your choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllProducts();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void listAllProducts() {
        System.out.println("List of all products:");

        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + ", $" + product.getPrice() + ", "
                    + product.getStock() + " in stock");
        }
    }

    private static void addNewProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product stock: ");
        int stock = scanner.nextInt();

        products.add(new Product(nextId++, name, price, stock));
        System.out.println("Product added successfully!");
    }

    private static void removeProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product index to remove: ");
        int index = scanner.nextInt();

        if (index >= 1 && index <= products.size()) {
            products.remove(index - 1);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private static void updateProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product index: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < products.size()) {
            System.out.print("Enter new price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter new amount in stock: ");
            int amountInStock = scanner.nextInt();

            products.get(index).setPrice(price);
            products.get(index).setAmountInStock(amountInStock);

            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Invalid product index!");
        }
    }
}
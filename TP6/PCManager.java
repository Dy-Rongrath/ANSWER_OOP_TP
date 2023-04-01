import java.util.Scanner;

public class PCManager {
    private static PC[] pcs = {
            new PC("PC1"),
            new PC("PC2"),
            new PC("PC3"),
            new PC("PC4"),
            new PC("PC5")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 6) {
            System.out.println("Menu:");
            System.out.println("1. List all PCs");
            System.out.println("2. List all damaged PCs");
            System.out.println("3. List all good PCs");
            System.out.println("4. Mark a PC as damaged");
            System.out.println("5. Mark a PC as not damaged");
            System.out.println("6. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllPCs();
                    break;
                case 2:
                    listDamagedPCs();
                    break;
                case 3:
                    listGoodPCs();
                    break;
                case 4:
                    markAsDamaged();
                    break;
                case 5:
                    markAsDamaged();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void listAllPCs() {
        System.out.println("All PCs in room 306F:");
        for (PC pc : pcs) {
            System.out.println(pc.getName() + " - " + (pc.isDamaged() ? "Damaged" : "Good"));
        }
    }

    private static void listDamagedPCs() {
        System.out.println("Damaged PCs in room 306F:");
        for (PC pc : pcs) {
            if (pc.isDamaged()) {
                System.out.println(pc.getName());
            }
        }
    }

    private static void listGoodPCs() {
        System.out.println("Good PCs in room 306F:");
        for (PC pc : pcs) {
            if (!pc.isDamaged()) {
                System.out.println(pc.getName());
            }
        }
    }

    private static void markAsDamaged() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the PC to mark as damaged: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (PC pc : pcs) {
            if (pc.getName().equals(name)) {
                pc.setDamaged(true);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(name + " has been marked as damaged.");
        }
    }
}

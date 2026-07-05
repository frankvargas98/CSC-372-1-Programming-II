import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean running = true;

        System.out.println("Welcome to the Library Management System!");

        while (running) {
            System.out.println("\n=================================");
            System.out.println("1. Add Book       4. Search by Title");
            System.out.println("2. Borrow Book    5. Print All Books");
            System.out.println("3. Return Book    6. Exit");
            System.out.println("=================================");
            System.out.print("Please enter your choice (1-6): ");

            int choice = 0;

            // Exception Handling for Menu Choice
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
            } catch (InputMismatchException e) {
                System.out.println("\n[Error] Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the bad input from the buffer
                continue; // Restart the loop
            }

            switch (choice) {
                case 1:
                    // Add Book
                    try {
                        System.out.print("Enter Book ID (integer): ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Enter Number of Pages: ");
                        int pages = scanner.nextInt();
                        scanner.nextLine();

                        Book newBook = new Book(id, title, author, isbn, pages);
                        inventory.addBook(newBook);
                        System.out.println("\n[Success] Book added to the library.");

                    } catch (InputMismatchException e) {
                        System.out.println("\n[Error] Invalid data type entered for ID or Pages. Book not added.");
                        scanner.nextLine(); // Clear bad input
                    }
                    break;

                case 2:
                    // Borrow Book
                    try {
                        System.out.print("Enter the ID of the book you want to borrow: ");
                        int borrowId = scanner.nextInt();

                        if (inventory.borrowBook(borrowId)) {
                            System.out.println("\n[Success] Book successfully borrowed.");
                        } else {
                            System.out.println("\n[Failed] Book not found or already borrowed.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n[Error] ID must be an integer.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    // Return Book
                    try {
                        System.out.print("Enter the ID of the book you are returning: ");
                        int returnId = scanner.nextInt();

                        if (inventory.returnBook(returnId)) {
                            System.out.println("\n[Success] Book successfully returned.");
                        } else {
                            System.out.println("\n[Failed] Error: Book is not currently in the lending list.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n[Error] ID must be an integer.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    // Search by Title
                    System.out.print("Enter the title (or partial title) to search: ");
                    String searchStr = scanner.nextLine();
                    System.out.println("\n--- Search Results ---");
                    inventory.searchByTitle(searchStr);
                    break;

                case 5:
                    // Print All Books
                    System.out.println("\n--- Main Inventory (Available Books: " + inventory.getMainInventoryCount() + ") ---");
                    inventory.printAll();
                    break;

                case 6:
                    // Exit
                    System.out.println("\nExiting the program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("\n[Error] Invalid option. Please select a number between 1 and 6.");
            }
        }
        scanner.close();
    }
}
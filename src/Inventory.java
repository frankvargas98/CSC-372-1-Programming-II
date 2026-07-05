import java.util.ArrayList;

public class Inventory {
    private ArrayList<Book> mainInventory;
    private ArrayList<Book> lendingInventory;

    public Inventory() {
        mainInventory = new ArrayList<>();
        lendingInventory = new ArrayList<>();
    }

    // Adds a new book to the library
    public void addBook(Book book) {
        mainInventory.add(book);
    }

    // Borrows a book
    public boolean borrowBook(int id) {
        for (Book book : mainInventory) {
            if (book.getId() == id) {
                mainInventory.remove(book);
                lendingInventory.add(book);
                return true; // Successfully borrowed
            }
        }
        return false; // Book not found in main inventory
    }

    // Returns a borrowed book
    public boolean returnBook(int id) {
        for (Book book : lendingInventory) {
            if (book.getId() == id) {
                lendingInventory.remove(book);
                mainInventory.add(book);
                return true; // Successfully returned
            }
        }
        return false; // Book not found in lending inventory
    }

    // Prints all available books
    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("The main inventory is currently empty.");
        } else {
            for (Book book : mainInventory) {
                book.printBookInfo();
            }
        }
    }

    // Searches for a book by partial or full title
    public void searchByTitle(String title) {
        boolean found = false;
        String searchLower = title.toLowerCase();

        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase().contains(searchLower)) {
                book.printBookInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    // Helper method to retrieve available book count
    public int getMainInventoryCount() {
        return mainInventory.size();
    }
}
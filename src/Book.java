public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int pages;

    // Default Constructor
    public Book() {
        this.id = 0;
        this.title = "Unknown";
        this.author = "Unknown";
        this.isbn = "0000000000";
        this.pages = 0;
    }

    // Parameterized Constructor
    public Book(int id, String title, String author, String isbn, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPages() { return pages; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPages(int pages) { this.pages = pages; }

    // Print Book Info Method
    public void printBookInfo() {
        System.out.printf("ID: %-4d | Title: %-25s | Author: %-20s | ISBN: %-15s | Pages: %d%n",
                id, title, author, isbn, pages);
    }
}
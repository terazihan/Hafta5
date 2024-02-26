import java.util.*;

class Book implements Comparable<Book> {
    private String title;
    private int pageCount;
    private String author;
    private Date publicationDate;

    public Book(String title, int pageCount, String author, Date publicationDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    // Override compareTo method to sort books by title (A to Z)
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    // Getter methods for Book class properties
    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    // Main method to demonstrate sorting books
    public static void main(String[] args) {
        // Create 5 Book objects
        Book book1 = new Book("Book E", 200, "Author E", new Date());
        Book book2 = new Book("Book D", 150, "Author D", new Date());
        Book book3 = new Book("Book C", 300, "Author C", new Date());
        Book book4 = new Book("Book B", 250, "Author B", new Date());
        Book book5 = new Book("Book A", 180, "Author A", new Date());

        // Create a TreeSet to store books sorted by title
        Set<Book> booksByTitle = new TreeSet<>();
        booksByTitle.add(book1);
        booksByTitle.add(book2);
        booksByTitle.add(book3);
        booksByTitle.add(book4);
        booksByTitle.add(book5);

        // Print books sorted by title
        System.out.println("Books sorted by title (A to Z):");
        for (Book book : booksByTitle) {
            System.out.println(book.getTitle());
        }

        // Create a TreeSet to store books sorted by page count
        Set<Book> booksByPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));
        booksByPageCount.add(book1);
        booksByPageCount.add(book2);
        booksByPageCount.add(book3);
        booksByPageCount.add(book4);
        booksByPageCount.add(book5);

        // Print books sorted by page count
        System.out.println("\nBooks sorted by page count:");
        for (Book book : booksByPageCount) {
            System.out.println(book.getTitle() + " - " + book.getPageCount() + " pages");
        }
    }
}

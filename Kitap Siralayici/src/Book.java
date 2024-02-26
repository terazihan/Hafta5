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

    // Kitapları başlığa göre sıralamak için CompareTo yöntemini geçersiz kıldık (A'dan Z'ye)
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    // Book sınıfı özellikleri için alıcı yöntemleri
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

    // Kitaplardaki sıralamayı gösterme yöntemi
    public static void main(String[] args) {
        // 5 Kitap nesnesi oluşturduk
        Book book1 = new Book("Bir Yazılımcı Öyküsü", 117, "Author Erhan Yildirim", new Date());
        Book book2 = new Book("Çocukluğum", 145, "Author Doruk Yildirim", new Date());
        Book book3 = new Book("Şarkılarda Hüzün Var", 80, "Author Ceylan Neylan", new Date());
        Book book4 = new Book("Dönence", 258, "Author Barış Manço", new Date());
        Book book5 = new Book("Anne Olmak Üzerine", 171, "Author Aslı Coşkun Yıldırım", new Date());

        // Kitapları başlığa göre sıralanmış olarak depolamak için bir TreeSet oluşturduk
        Set<Book> booksByTitle = new TreeSet<>();
        booksByTitle.add(book1);
        booksByTitle.add(book2);
        booksByTitle.add(book3);
        booksByTitle.add(book4);
        booksByTitle.add(book5);

        // Kitapları başlığa göre sıralanmış olarak yazdırma
        System.out.println("Books sorted by title (A to Z):");
        for (Book book : booksByTitle) {
            System.out.println(book.getTitle());
        }

        // Sayfa sayısına göre sıralanmış kitapları depolamak için bir TreeSet oluşturduk
        Set<Book> booksByPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));
        booksByPageCount.add(book1);
        booksByPageCount.add(book2);
        booksByPageCount.add(book3);
        booksByPageCount.add(book4);
        booksByPageCount.add(book5);

        // Kitapları sayfa sayısına göre sıralanmış olarak yazdırma
        System.out.println("\nBooks sorted by page count:");
        for (Book book : booksByPageCount) {
            System.out.println(book.getTitle() + " - " + book.getPageCount() + " pages");
        }
    }
}

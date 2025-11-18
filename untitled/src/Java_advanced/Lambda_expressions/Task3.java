package Java_advanced.Lambda_expressions;

public class Task3 {
    public static void main(String[] args) {
        Book book = new Book("Антуан де Сент-Екзюпері", "Маленький принц", 100);


        String message = "Reading a book: ";

        Read read1 = (() -> System.out.println(message + " " + book));


        read1.readBook();

        Read read = new Read() {
            @Override
            public void readBook() {
                System.out.println(message + " " + book);
            }
        };
        read.readBook();
    }

}

class Book {
    private String author;
    private String name;
    private int page;

    public Book(String author, String name, int page) {
        this.author = author;
        this.name = name;
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", page=" + page;
    }
}

@FunctionalInterface
interface Read {
    void readBook();
}
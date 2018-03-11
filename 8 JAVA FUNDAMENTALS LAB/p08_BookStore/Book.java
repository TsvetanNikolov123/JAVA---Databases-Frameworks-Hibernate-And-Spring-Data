package p08_BookStore;

public class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, double price, String author) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }
}

package p08_BookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library();
        int booksCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < booksCount; i++) {
            String[] info = reader.readLine().split("\\s+");
            String title = info[0];
            String author = info[1];
            String publisher = info[2];
            String releaseDate = info[3];
            String ISBN = info[4];
            double price = Double.parseDouble(info[5]);

            Book book = new Book(title, author, publisher, releaseDate, ISBN, price);
            library.adBook(book);
        }

        library.getBooks()
                .stream()
                .collect(
                        Collectors
                                .groupingBy(Book::getAuthor,
                                        Collectors.summingDouble(Book::getPrice)))
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = Double.compare(b.getValue(), a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(a -> {
            System.out.printf("%s -> %.2f%n", a.getKey(), a.getValue());
        });
    }
}

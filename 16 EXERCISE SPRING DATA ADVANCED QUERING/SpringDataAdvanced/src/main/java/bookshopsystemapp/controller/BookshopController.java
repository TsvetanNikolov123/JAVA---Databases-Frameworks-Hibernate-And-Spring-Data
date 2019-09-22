package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.authorService.seedAuthors();
//        this.categoryService.seedCategories();
//        this.bookService.seedBooks();

        p01BookTitlesByAgeRestriction();
//        p02GoldenBooks();
//        p03BooksByPrice();
//        p04NotReleasedBooks();
//        p05BooksReleasedBeforeDate();
//        p06AuthorsSearch();
//        p07BooksSearch();
//        p08BookTitlesSearch();
//        p09CountBooks();
//        p10TotalBookCopies();
//        p11ReducedBook();

    }

    private void p11ReducedBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        System.out.println(this.bookService.getBookDetailsByTitle(scanner.nextLine()));
    }

    private void p10TotalBookCopies() {
        bookService.selectAuthorsWithSumOfCopiesOrderedDesc().forEach(System.out::println);
    }

    private void p09CountBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title length: ");
        int searchedLength = Integer.parseInt(scanner.nextLine());
        int result = this.bookService.numberOfBooksWithTitleLongerThanGivenNumber(searchedLength);

        System.out.println(result);
    }

    private void p08BookTitlesSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter part of searched name: ");
        String searchedString = scanner.nextLine();

        String result = this.bookService.booksTitleWithAuthorsLastNameStartsWith(searchedString);
        System.out.println(result);

    }

    private void p07BooksSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter part of searched name: ");
        String searchedString = scanner.nextLine();

        String result = this.bookService.booksContainingGivenString(searchedString);
        System.out.println(result);
    }

    private void p06AuthorsSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter last part of searched name: ");
        String endsWith = scanner.nextLine();

        String result = this.authorService.authorsSearch(endsWith);

        System.out.println(result);
    }

    private void p05BooksReleasedBeforeDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date: ");
        String dateAsString = scanner.nextLine();

        String result = this.bookService.booksReleasedBeforeDate(dateAsString);
        System.out.println(result);
    }

    private void p04NotReleasedBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        String yearAsString = scanner.nextLine();

        String result = this.bookService.notReleasedBooks(yearAsString);

        System.out.println(result);
    }

    private void p03BooksByPrice() {
        System.out.println(this.bookService.booksByPrice());
    }

    private void p02GoldenBooks() {
        this.bookService.getBookTitleOfGoldenEditionBooksWithLessThan5000Copies()
                .forEach(b -> System.out.println(b));
    }

    private void p01BookTitlesByAgeRestriction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age restriction: ");
        String ageRestrictionStr = scanner.nextLine();

        this.bookService.getBookTitleByAgeRestriction(ageRestrictionStr).forEach(b -> System.out.println(b));
    }
}

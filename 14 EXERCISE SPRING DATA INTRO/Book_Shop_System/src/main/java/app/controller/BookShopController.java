package app.controller;

import app.service.AuthorService;
import app.service.BookService;
import app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookShopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookShopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
       // this.authorService.seedAuthors();
       // this.categoryService.seedCategories();
       // this.bookService.seedBooks();

        List<String> bookTitles = this.bookService.getAllBooksTitlesAfter();

        System.out.println(String.join("\r\n", bookTitles));
    }
}

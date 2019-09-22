package app.service;

import app.domain.entities.Author;
import app.domain.entities.Book;
import app.domain.entities.Category;
import app.domain.entities.enums.AgeRestriction;
import app.domain.entities.enums.EditionType;
import app.repository.AuthorRepository;
import app.repository.BookRepository;
import app.repository.CategoryRepository;
import app.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    private final static String BOOKS_FILE_PATH =
            "C:\\OneDrive\\Java\\JAVA DB\\October 2018\\14 EXERCISE SPRING DATA INTRO\\Book_Shop_System\\src\\main\\resources\\files\\books.txt";
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0){
            return;
        }

        String[] bookFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : bookFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i])
                        .append(" ");
            }

            book.setTitle(title.toString().trim());
            Set<Category> categories = this.getRandomCategories();
            book.setCategory(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));
        String debug = "";
        return books.stream().map(b->b.getTitle()).collect(Collectors.toList());
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Category getRandomCategory(){
        Random random = new Random();
        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories(){
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);
        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();
            categories.add(category);
        }

        return categories;
    }
}

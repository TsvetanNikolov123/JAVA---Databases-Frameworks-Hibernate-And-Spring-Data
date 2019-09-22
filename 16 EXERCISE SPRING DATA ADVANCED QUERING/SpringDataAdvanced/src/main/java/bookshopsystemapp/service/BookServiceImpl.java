package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "C:\\OneDrive\\Java\\JAVA DB\\October 2018\\16 EXERCISE SPRING DATA ADVANCED QUERING\\SpringDataAdvanced\\src\\main\\resources\\files\\books.txt";

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
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
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
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    @Override
    public List<String> getBookTitleByAgeRestriction(String ageRestrictionStr) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionStr.toUpperCase());
        List<Book> books = this.bookRepository.findAllByAgeRestriction(ageRestriction);

        return books.stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitleOfGoldenEditionBooksWithLessThan5000Copies() {
        List<Book> books = this.bookRepository.getBooksByEditionTypeIsAndCopiesLessThan(EditionType.GOLD, 5000);

        return books.stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());
    }

    @Override
    public String booksByPrice() {
        List<Book> books = this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(4), BigDecimal.valueOf(40));

        return String.join(System.lineSeparator(),
                books.stream()
                        .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                        .collect(Collectors.toList()));
    }

    @Override
    public String notReleasedBooks(String yearAsString) {
        LocalDate before = LocalDate.parse(yearAsString + "-01-01");
        LocalDate after = LocalDate.parse(yearAsString + "-12-31");
        List<Book> books = this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before, after);

        List<String> bookTitles = books.stream().map(book -> book.getTitle()).collect(Collectors.toList());

        return String.join(System.lineSeparator(), bookTitles);
    }

    @Override
    public String booksReleasedBeforeDate(String dateAsString) {
        LocalDate date = LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date);
        List<String> titles = books.stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());

        return String.join(System.lineSeparator(), titles);
    }

    @Override
    public String booksContainingGivenString(String inputString) {
        List<Book> books = this.bookRepository.findAllByTitleContains(inputString);
        List<String> titlesWithSearchedContent = books.stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());

        return String.join(System.lineSeparator(), titlesWithSearchedContent);
    }

    @Override
    public String booksTitleWithAuthorsLastNameStartsWith(String startsWith) {
        List<Book> books = this.bookRepository.getBooksByAuthorWithLastNameStartsWith(startsWith);

        return String.join(System.lineSeparator(),
                books.stream()
                        .map(book -> String.format("%s (%s %s)",
                                book.getTitle(),
                                book.getAuthor().getFirstName(),
                                book.getAuthor().getLastName()))
                        .collect(Collectors.toList()));
    }

    @Override
    public Integer numberOfBooksWithTitleLongerThanGivenNumber(int searchedLength) {

        return this.bookRepository.getCountOfBooksWithTitleLongerThan(searchedLength);
    }

    @Override
    public List<String> selectAuthorsWithSumOfCopiesOrderedDesc() {
        Map<Author, Integer> authors = new LinkedHashMap<>();
        for (Book book : bookRepository.findAllBy()) {
            authors.putIfAbsent(book.getAuthor(), sumOfCopies(bookRepository.findAllBy(), book.getAuthor()));
        }
        return authors.entrySet().stream().
                sorted((kv1, kv2) -> kv2.getValue().
                        compareTo(kv1.getValue())).
                map(kv -> java.lang.String.format("%s %s - %d",
                        kv.getKey().getFirstName(),
                        kv.getKey().getLastName(),
                        kv.getValue())).
                collect(Collectors.toList());
    }

    @Override
    public String getBookDetailsByTitle(String title) {
        ReducedBook reducedBook = this.bookRepository.getBookByTitle(title);
        return (reducedBook == null) ? "Book Not Found" : reducedBook.toString();
    }

    private int sumOfCopies(List<Book> books, Author author) {
        return books.stream().filter(book -> book.getAuthor().equals(author)).mapToInt(Book::getCopies).sum();
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }
}

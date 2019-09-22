package bookshopsystemapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> getBookTitleByAgeRestriction(String ageRestrictionStr);

    List<String> getBookTitleOfGoldenEditionBooksWithLessThan5000Copies();

    String booksByPrice();

    String notReleasedBooks(String yearAsString);

    String booksReleasedBeforeDate(String dateAsString);

    String booksContainingGivenString(String inputString);

    String booksTitleWithAuthorsLastNameStartsWith(String startsWith);

    Integer numberOfBooksWithTitleLongerThanGivenNumber(int searchedLength);

    List<String> selectAuthorsWithSumOfCopiesOrderedDesc();

    String getBookDetailsByTitle(String title);
}

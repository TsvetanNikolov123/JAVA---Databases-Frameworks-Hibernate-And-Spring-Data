package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import bookshopsystemapp.domain.entities.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getBooksByEditionTypeIsAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lessThan, BigDecimal greaterThan);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByTitleContains(String inputString);

    @Query("SELECT b FROM bookshopsystemapp.domain.entities.Book AS b WHERE b.author.lastName LIKE :startWith%")
    List<Book> getBooksByAuthorWithLastNameStartsWith(@Param("startWith") String startWith);

    @Query("SELECT COUNT(b) FROM bookshopsystemapp.domain.entities.Book AS b WHERE LENGTH(b.title) >= :length")
    Integer getCountOfBooksWithTitleLongerThan(@Param("length") int length);

    List<Book> findAllBy();

    ReducedBook getBookByTitle(String title);
}

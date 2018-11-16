package advancedquerying.repository;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    // Select shampoos by given size order by id asc;
    List<Shampoo> findAllBySizeOrderById(Size size);

    // Select shampoos by given size or label_id order by price ASC;
    List<Shampoo> findShampooBySizeOrLabel_IdOrderByPriceAsc(Size size, Long id);

    // Selects all shampoos, which price is higher than a given price.
    // Sort descending by price.
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    // Create a method that counts all shampoos with price lower than a given price.
    List<Shampoo> findAllByPriceIsLessThan(BigDecimal price);

    @Query("SELECT s FROM advancedquerying.domain.entities.Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i IN :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Set<Ingredient> ingredients);
}

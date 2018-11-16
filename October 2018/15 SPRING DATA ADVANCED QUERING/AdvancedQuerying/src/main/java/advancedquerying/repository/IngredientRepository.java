package advancedquerying.repository;

import advancedquerying.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // Create a method that selects all ingredients, which name starts with given letters.
    List<Ingredient> findAllByNameStartsWith(String letter);

    // Create a method that selects all ingredients, which are contained in a given list.
    // Sort the result ascending by price.
    List<Ingredient> findAllByNameIsInOrderByPriceAsc(List<String> names);

    Set<Ingredient> findAllByNameIn(List<String> ingredientNames);
}

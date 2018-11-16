package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> selectIngredientsByName(String name) {
        List<Ingredient> ingredients = this.ingredientRepository.findAllByNameStartsWith(name);

        return ingredients
                .stream()
                .map(ingredient -> String.format("%s", ingredient.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectIngredientsByName(List<String> names) {
        List<Ingredient> ingredients = this.ingredientRepository.findAllByNameIsInOrderByPriceAsc(names);

        return ingredients
                .stream()
                .map(ingredient -> String.format("%s", ingredient.getName()))
                .collect(Collectors.toList());
    }
}

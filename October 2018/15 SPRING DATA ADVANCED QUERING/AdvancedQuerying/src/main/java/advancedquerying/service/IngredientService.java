package advancedquerying.service;

import java.util.List;

public interface IngredientService {

    List<String> selectIngredientsByName(String name);

    List<String> selectIngredientsByName(List<String> names);
}

package advancedquerying.service;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<String> selectShampoosBySize(String inputSize);

    String selectShampoosBySizeOrLabel(String inputSize, Long id);

    List<String> selectShampoosByPrice(BigDecimal price);

    int countShampoosByPrice(BigDecimal price);

    List<String> selectShampoosByIngredients(List<String> ingredientNames);
}

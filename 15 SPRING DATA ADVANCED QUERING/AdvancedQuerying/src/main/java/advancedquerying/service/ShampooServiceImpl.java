package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import advancedquerying.repository.IngredientRepository;
import advancedquerying.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> selectShampoosBySize(String inputSize) {
        Size size = Size.valueOf(inputSize.toUpperCase());
        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrderById(size);

        return shampoos
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public String selectShampoosBySizeOrLabel(String inputSize, Long id) {
        Size size = Size.valueOf(inputSize.toUpperCase());

        List<Shampoo> shampoos =
                this.shampooRepository.findShampooBySizeOrLabel_IdOrderByPriceAsc(size, id);

        return String.join(
                System.lineSeparator(),
                shampoos
                        .stream()
                        .map(shampoo -> String.format("%s %s %.2flv.",
                                shampoo.getBrand(),
                                shampoo.getSize(),
                                shampoo.getPrice()))
                        .collect(Collectors.toList()));
    }

    @Override
    public List<String> selectShampoosByPrice(BigDecimal price) {

        List<Shampoo> shampoos = this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
        return shampoos
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public int countShampoosByPrice(BigDecimal price) {

        List<Shampoo> shampoos = this.shampooRepository.findAllByPriceIsLessThan(price);

        return shampoos.size();
    }

    @Override
    public List<String> selectShampoosByIngredients(List<String> ingredientNames) {
        Set<Ingredient> ingredients = this.ingredientRepository.findAllByNameIn(ingredientNames);
        List<Shampoo> shampoos = this.shampooRepository.findByIngredientsIn(ingredients);
        return shampoos.stream().map(shampoo -> shampoo.getBrand()).collect(Collectors.toList());
    }
}

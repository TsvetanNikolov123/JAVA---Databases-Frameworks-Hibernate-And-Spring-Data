package advancedquerying.controller;

import advancedquerying.service.IngredientService;
import advancedquerying.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public AppController(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

//        p01SelectShampoosBySize(scanner);
//        p02SelectShampoosBySizeOrLabel(scanner);
//        p03SelectShampoosByPrice(scanner);
//        p04SelectIngredientsByName(scanner);
//        p05SelectIngredientsByNames(scanner);
//        p06CountShampoosByPrice(scanner);
//        p07SelectShampoosByIngredients(scanner);

    }

    private void p07SelectShampoosByIngredients(Scanner scanner) {
        List<String> lines = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            if ("".equals(line)) {
                break;
            }

            lines.add(line);
        }

        this.shampooService.selectShampoosByIngredients(lines).forEach(System.out::println);
    }

    private void p06CountShampoosByPrice(Scanner scanner) {
        System.out.print("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        int result = this.shampooService.countShampoosByPrice(price);
        System.out.println(result);
    }

    private void p05SelectIngredientsByNames(Scanner scanner) {

        System.out.print("Enter names separated by space: ");

        List<String> inputNames = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        List<String> result = this.ingredientService.selectIngredientsByName(inputNames);
        result.forEach(System.out::println);
    }

    private void p04SelectIngredientsByName(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        List<String> result = this.ingredientService.selectIngredientsByName(name);
        result.forEach(System.out::println);
    }

    private void p03SelectShampoosByPrice(Scanner scanner) {
        System.out.print("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        List<String> result = this.shampooService.selectShampoosByPrice(price);
        result.forEach(System.out::println);
    }

    private void p02SelectShampoosBySizeOrLabel(Scanner scanner) {
        System.out.print("Enter size: ");
        String inputSize = scanner.nextLine();
        System.out.print("Enter id");
        Long inputId = Long.parseLong(scanner.nextLine());

        String result = this.shampooService.selectShampoosBySizeOrLabel(inputSize, inputId);
        System.out.println(result);
    }

    private void p01SelectShampoosBySize(Scanner scanner) {
        System.out.print("Enter size: ");
        String inputSize = scanner.nextLine();

        List<String> result = this.shampooService.selectShampoosBySize(inputSize);
        result.forEach(System.out::println);
    }
}

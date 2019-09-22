package productshop.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import productshop.domain.dtos.binding.CategorySeedDto;
import productshop.domain.dtos.binding.ProductSeedDto;
import productshop.domain.dtos.binding.UserSeedDto;
import productshop.domain.dtos.view.ProductsInRangeDto;
import productshop.domain.dtos.view.UserFirstAndLastNameWithAtLeastOneSaleDto;
import productshop.service.CategoryService;
import productshop.service.ProductService;
import productshop.service.UserService;
import productshop.util.FileIOUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {

    private final static String RESOURCES_PATH = System.getProperty("user.dir") + "/src/main/resources/";
    private final static String OUTPUT_PRODUCTS_IN_RANGE_JSON = RESOURCES_PATH + "files/output/products-in-range.json";
    private final static String OUTPUT_USERS_SOLD_PRODUCTS_JSON = RESOURCES_PATH + "files/output/users-sold-products.json";
    private final static String USER_FILE_PATH = "/files/users.json";
    private final static String CATEGORIES_FILE_PATH = "/files/categories.json";
    private final static String PRODUCTS_FILE_PATH = "/files/products.json";

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final FileIOUtil fileIOUtil;
    private final Gson gson;

    @Autowired
    public ProductShopController(UserService userService, CategoryService categoryService, ProductService productService, FileIOUtil fileIOUtil, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.fileIOUtil = fileIOUtil;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedUsers();
        /**
         * 02 -> Seed The Database
         */

//        seedDatabase();

        /**
         * 03 -> Query And Export Data
         */
        q1_ProductsInRange();
        q2_SuccessfullySoldProducts();
    }


    private void q2_SuccessfullySoldProducts() {
        List<UserFirstAndLastNameWithAtLeastOneSaleDto> userFirstAndLastNameWithAtLeastOneSaleDtos =
                this.userService.getSuccessfulSellers();
        String userFirstAndLastNameWithAtLeastOneSaleJson = this.gson.toJson(userFirstAndLastNameWithAtLeastOneSaleDtos);
        this.fileIOUtil.write(userFirstAndLastNameWithAtLeastOneSaleJson,OUTPUT_USERS_SOLD_PRODUCTS_JSON);
    }

    private void q1_ProductsInRange() throws IOException {
        List<ProductsInRangeDto> productsInRangeDtos = this.productService.productInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        String productsInRangeJson = this.gson.toJson(productsInRangeDtos);
        this.fileIOUtil.write(productsInRangeJson, OUTPUT_PRODUCTS_IN_RANGE_JSON);
    }

    private void seedUsers() throws IOException {
        String usersFileContent = this.fileIOUtil.readFileFromResources(USER_FILE_PATH);
        UserSeedDto[] userSeedDtos = this.gson.fromJson(usersFileContent, UserSeedDto[].class);
        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws IOException {
        String categoriesFileContent = this.fileIOUtil.readFileFromResources(CATEGORIES_FILE_PATH);
        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(categoriesFileContent, CategorySeedDto[].class);
        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedProducts() throws IOException {
        String productsFileContent = this.fileIOUtil.readFileFromResources(PRODUCTS_FILE_PATH);
        ProductSeedDto[] productSeedDtos = this.gson.fromJson(productsFileContent, ProductSeedDto[].class);
        this.productService.seedProducts(productSeedDtos);
    }

    private void seedDatabase() throws IOException {
        this.seedUsers();
        this.seedCategories();
        this.seedProducts();
    }
}

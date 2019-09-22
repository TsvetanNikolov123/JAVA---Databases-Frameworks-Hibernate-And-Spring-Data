package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.binding.ProductSeedDto;
import productshop.domain.dtos.view.ProductsInRangeDto;
import productshop.domain.entities.Category;
import productshop.domain.entities.Product;
import productshop.domain.entities.User;
import productshop.repository.CategoryRepository;
import productshop.repository.ProductRepository;
import productshop.repository.UserRepository;
import productshop.util.ValidatorUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpls implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    public ProductServiceImpls(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        for (ProductSeedDto productSeedDto : productSeedDtos) {
            if (!this.validatorUtil.isValid(productSeedDto)) {
                this.validatorUtil.violations(productSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));
                continue;
            }

            Product entity = this.modelMapper.map(productSeedDto, Product.class);
            entity.setSeller(this.getRandomUser());
            Random random = new Random();
            if (random.nextInt() % 13 != 0) {
                entity.setBuyer(this.getRandomUser());
            }

            entity.setCategories(this.getRandomCategories());
            this.productRepository.saveAndFlush(entity);
        }
    }

    @Override
    public List<ProductsInRangeDto> productInRange(BigDecimal more, BigDecimal less) {
        List<Product> productEntities = this.productRepository.findAllByPriceBetweenAndBuyerOrderByPrice(more, less, null);
        List<ProductsInRangeDto> productsInRangeDtos = new ArrayList<>();
        for (Product productEntity : productEntities) {
            ProductsInRangeDto productsInRangeDto = this.modelMapper.map(productEntity, ProductsInRangeDto.class);
            productsInRangeDto.setSeller(String.format("%s %s",
                    productEntity.getSeller().getFirstName(),
                    productEntity.getSeller().getLastName()));
            productsInRangeDtos.add(productsInRangeDto);
        }
        return productsInRangeDtos;
    }

    private User getRandomUser() {
        Random random = new Random();
        return this.userRepository.getOne(random.nextInt((int) this.userRepository.count() - 1) + 1);
    }

    private List<Category> getRandomCategories() {
        Random random = new Random();
        List<Category> categories = new ArrayList<>();
        int categoryCount = random.nextInt((int) this.categoryRepository.count() - 1) + 1;
        for (int i = 0; i < categoryCount; i++) {
            categories.add(this.categoryRepository.getOne(random.nextInt((int) this.categoryRepository.count() - 1) + 1));
        }
        return categories;
    }
}

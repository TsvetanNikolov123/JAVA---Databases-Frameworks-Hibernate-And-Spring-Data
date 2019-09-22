package productshop.service;

import productshop.domain.dtos.binding.ProductSeedDto;
import productshop.domain.dtos.view.ProductsInRangeDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductsInRangeDto> productInRange(BigDecimal more, BigDecimal less);


}

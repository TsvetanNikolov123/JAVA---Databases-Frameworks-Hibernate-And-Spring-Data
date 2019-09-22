package productshop.service;

import productshop.domain.dtos.binding.CategorySeedDto;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDtos);
}

package org.example.services;

import org.example.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void saveCategory(Category category);
    Optional<Category> findCategoryById(Long id);

    List<Category> findAllCategories();

    List<Category> findCategoriesByFlowType (String flowType);

//    Category findCategoryByName(String name);

//    Category updateCategoryName(Long id);

}

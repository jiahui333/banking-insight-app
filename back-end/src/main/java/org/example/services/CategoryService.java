package org.example.services;

import org.example.models.Category;

import java.util.Optional;

public interface CategoryService {
    void saveCategory(Category category);
    Optional<Category> findCategoryById(Long id);

    Category updateCategoryName(Long id);
}

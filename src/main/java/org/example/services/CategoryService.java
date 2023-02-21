package org.example.services;

import org.example.models.Category;

public interface CategoryService {
    void createCategory(String name);

    void renameCategory(Category category, String newName);

    void autoCategorize();
}

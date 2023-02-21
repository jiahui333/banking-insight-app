package org.example.repositories;

import org.example.models.Category;

public interface CategoryRepo {
    void storeCategory(String name);

    void renameCategory(Category category, String name);
}

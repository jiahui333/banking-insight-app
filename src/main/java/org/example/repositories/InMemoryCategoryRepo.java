package org.example.repositories;

import org.example.models.Category;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCategoryRepo implements CategoryRepo{


    @Override
    public void storeCategory(String name) {
        new Category(name);
    }

    @Override
    public void renameCategory(Category category, String name) {
        category.setName(name);
    }
}

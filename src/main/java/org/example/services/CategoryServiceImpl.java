package org.example.services;

import org.example.models.Category;
import org.example.repositories.CategoryRepo;
import org.example.repositories.InMemoryCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo inMemoryCategoryRepo;

    @Override
    public void createCategory(String name) {
        inMemoryCategoryRepo.storeCategory(name);
    }

    @Override
    public void renameCategory(Category category, String newName) {
        inMemoryCategoryRepo.renameCategory(category, newName);
    }

    @Override
    public void autoCategorize() {

    }
}

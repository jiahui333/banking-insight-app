package org.example.services;

import org.example.models.Category;
import org.example.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepo.findById(id);
    }


//    @Override
//    public void autoCategorize() {
//
//    }
}

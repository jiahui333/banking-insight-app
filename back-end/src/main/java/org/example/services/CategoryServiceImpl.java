package org.example.services;

import org.example.models.Category;
import org.example.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    //not finished
    @Override
    public Category updateCategoryName(Long id) {
        return null;
    }

//    @Override
//    public Category updateCategoryName(Long id) {
//        return categoryRepo.
//    }


//    @Override
//    public void autoCategorize() {
//
//    }
}

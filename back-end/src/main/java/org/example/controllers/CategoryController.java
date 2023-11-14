package org.example.controllers;

import org.example.models.Category;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{flowType}")
    public List<Category> getCategoriesByFlowType(@PathVariable("flowType") String flowType) {
        return categoryService.findCategoriesByFlowType(flowType);
    }

    @PostMapping
    void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }
}

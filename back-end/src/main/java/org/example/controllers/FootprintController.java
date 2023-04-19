package org.example.controllers;

import org.example.models.Category;
import org.example.models.Transaction;
import org.example.services.CategoryService;
import org.example.services.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/{category_name}/footprint")

public class FootprintController {

    @Autowired
    FootprintService footprintService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public BigDecimal getFootprintPerCategory(@PathVariable("category_name") String categoryName) {
        Category category = categoryService.findCategoryByName(categoryName);
        return footprintService.calculateFootprintPerCategory(category);
    }
}

package org.example.controllers;

import org.example.models.Category;
import org.example.models.Footprint;
import org.example.models.Transaction;
import org.example.services.CategoryService;
import org.example.services.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/footprint")

public class FootprintController {

    @Autowired
    FootprintService footprintService;

    @GetMapping("/per-category")
    public Map<String, BigDecimal> getAllFootprintPerCategory() {
        return footprintService.calculateCategoryFootprintMap();
    }

    @GetMapping("/per-year-month")
    public Map<String, BigDecimal> getAllFootprintPerYearMonth() {
        return footprintService.calculateYearMonthFootprintMap();
    }
}

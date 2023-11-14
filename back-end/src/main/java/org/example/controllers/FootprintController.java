package org.example.controllers;

import org.example.models.Category;
import org.example.models.Footprint;
import org.example.models.Transaction;
import org.example.models.User;
import org.example.services.CategoryService;
import org.example.services.FootprintService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/footprint")

public class FootprintController {
    @Autowired
    private UserService userService;

    @Autowired
    FootprintService footprintService;

    @GetMapping("/per-category")
    public Map<String, BigDecimal> getAllFootprintPerCategory(Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        return footprintService.calculateCategoryFootprintMap(currentUser);
    }

    @GetMapping("/per-year-month")
    public Map<String, BigDecimal> getAllFootprintPerYearMonth(Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        return footprintService.calculateYearMonthFootprintMap(currentUser);
    }
}

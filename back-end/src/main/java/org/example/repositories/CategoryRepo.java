package org.example.repositories;

import org.example.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);

    List<Category> findAllByFlowType(String flowType);
}

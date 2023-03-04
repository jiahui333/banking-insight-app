package org.example.repositories;

import org.example.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    // need to double check
    @Transactional
    @Modifying
    @Query("update Category c set c.name = ?1 where c.name = ?2")
    void updateCategoryName(@NonNull String name, String name1);
}

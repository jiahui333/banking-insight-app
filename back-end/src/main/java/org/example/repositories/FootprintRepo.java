package org.example.repositories;

import org.example.models.Category;
import org.example.models.Footprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootprintRepo extends JpaRepository<Footprint, Long> {
    List<Footprint> findAllByCategory(Category category);
}

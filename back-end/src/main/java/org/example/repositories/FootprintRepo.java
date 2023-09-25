package org.example.repositories;

import org.example.models.Category;
import org.example.models.Footprint;
import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootprintRepo extends JpaRepository<Footprint, Long> {
    List<Footprint> findAllByUser(User user);
}

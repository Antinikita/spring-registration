package org.example.springlab5.repositories;

import org.example.springlab5.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<org.example.springlab5.models.Category, Long> {
}

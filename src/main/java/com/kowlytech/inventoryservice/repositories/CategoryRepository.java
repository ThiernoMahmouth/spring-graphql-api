package com.kowlytech.inventoryservice.repositories;

import com.kowlytech.inventoryservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

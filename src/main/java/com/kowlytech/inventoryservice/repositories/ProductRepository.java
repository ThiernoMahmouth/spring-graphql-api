package com.kowlytech.inventoryservice.repositories;

import com.kowlytech.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}

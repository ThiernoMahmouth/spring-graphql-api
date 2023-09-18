package com.kowlytech.inventoryservice;

import com.kowlytech.inventoryservice.entities.Category;
import com.kowlytech.inventoryservice.entities.Product;
import com.kowlytech.inventoryservice.repositories.CategoryRepository;
import com.kowlytech.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    /*
    @Bean
    public CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, ProductRepository productRepository)
    {
        return args -> {
            Random random = new Random();
            List.of("Computer", "Printer", "SmartPhone").forEach(categorie ->{
                Category category = Category.builder().name(categorie).build();
                categoryRepository.save(category);
            });

            categoryRepository.findAll().forEach(category -> {
                for (int i = 0; i < 10; i++) {
                    Product product = Product.builder()
                            .id(1 + random.nextLong())
                            .name(category.getName() + " " + i)
                            .price(100 + Math.random() * 5000)
                            .quantity(random.nextInt(100))
                            .category(category)
                            .build();
                    productRepository.save(product);
                }
            });
        };
    }
    */
}

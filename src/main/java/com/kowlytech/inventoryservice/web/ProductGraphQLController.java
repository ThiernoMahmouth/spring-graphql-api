package com.kowlytech.inventoryservice.web;

import com.kowlytech.inventoryservice.dtos.ProductRequestDTO;
import com.kowlytech.inventoryservice.entities.Category;
import com.kowlytech.inventoryservice.entities.Product;
import com.kowlytech.inventoryservice.repositories.CategoryRepository;
import com.kowlytech.inventoryservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class ProductGraphQLController
{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @QueryMapping
    public List<Product> productList()
    {
        return productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument Long id)
    {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Product %d not found", id)));
    }

    @MutationMapping
    public Product saveProduct(@Argument ProductRequestDTO productRequestDTO)
    {

        Category category = categoryRepository.findById(productRequestDTO.categoryId())
                            .orElseThrow(()->new RuntimeException("Cette catégorie n'existe pas!"));
        Product productToSave = Product.builder()
                                    .name(productRequestDTO.name())
                                    .price(productRequestDTO.price())
                                    .quantity(productRequestDTO.quantity())
                                    .category(category)
                                    .build();
        return productRepository.save(productToSave);
    }

    @MutationMapping
    public Product updateProduct(@Argument ProductRequestDTO productRequestDTO)
    {

        Product productToUpdate = productRepository.findById(productRequestDTO.id()).orElseThrow(()->new RuntimeException(String.format("Le produit %d n'existe pas!", productRequestDTO.id())));;
        Category category = categoryRepository.findById(productRequestDTO.categoryId()).orElseThrow(()->new RuntimeException("Cette catégorie n'existe pas!"));

        productToUpdate.setName(productRequestDTO.name());
        productToUpdate.setPrice(productRequestDTO.price());
        productToUpdate.setQuantity(productRequestDTO.quantity());
        productToUpdate.setCategory(category);
        return productRepository.save(productToUpdate);
    }

    @MutationMapping
    public boolean deleteProduct(@Argument Long id)
    {
        Product productToDelete = productRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Le produit %d n'existe pas!", id)));

        try
        {
            productRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}

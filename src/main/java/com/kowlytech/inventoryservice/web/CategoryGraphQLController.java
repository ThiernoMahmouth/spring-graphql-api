package com.kowlytech.inventoryservice.web;

import com.kowlytech.inventoryservice.dtos.CategoryRequestDTO;
import com.kowlytech.inventoryservice.entities.Category;
import com.kowlytech.inventoryservice.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class CategoryGraphQLController
{
    private CategoryRepository categoryRepository;
    private MessageSource messageSource;

    @QueryMapping
    public List<Category> categoryList()
    {
        return categoryRepository.findAll();
    }

    @QueryMapping
    public Category categoryById(@Argument Long id)
    {
        return categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Category %d not found", id)));
    }

    @MutationMapping
    public Category saveCategory(@Argument CategoryRequestDTO categoryRequestDTO)
    {
        Category categoryToSave = Category.builder()
                                    .name(categoryRequestDTO.name())
                                    .build();
        return categoryRepository.save(categoryToSave);
    }

    @MutationMapping
    public Category updateCategory(@Argument CategoryRequestDTO categoryRequestDTO)
    {
        Category categoryToUpdate = categoryRepository.findById(categoryRequestDTO.id())
                .orElseThrow(()->new RuntimeException(String.format("Category %d not found", categoryRequestDTO.id())));
        categoryToUpdate.setName(categoryRequestDTO.name());
        return categoryRepository.save(categoryToUpdate);
    }
    @MutationMapping
    public boolean deleteCategory(@Argument Long id)
    {
        try
        {
            categoryRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}

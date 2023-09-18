package com.kowlytech.inventoryservice.dtos;


import com.kowlytech.inventoryservice.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public record ProductRequestDTO(Long id, String name, double price, int quantity, Long categoryId) {}

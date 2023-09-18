package com.kowlytech.inventoryservice.dtos;

import com.kowlytech.inventoryservice.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

public record CategoryRequestDTO (Long id, String name) {}

package com.example.shop.web.dto.category;

import com.example.shop.model.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public abstract class CategoryDTO {
    @NotBlank(message = "Name should not be blank")
    private String name;
    @Size(min = 10, message = "Description should be longer then 10")
    private String description;
    private boolean active;
    private List<Product> products;
}

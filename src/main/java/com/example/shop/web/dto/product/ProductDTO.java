package com.example.shop.web.dto.product;

import com.example.shop.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class ProductDTO {
    @Size(min = 3, message = "Name should be longer then 3 symbols")
    private String name;
    @NotBlank(message = "Description should not be a blank")
    private String description;
    private BigDecimal price;
    @JsonIgnoreProperties("products")
    private Category category;
}

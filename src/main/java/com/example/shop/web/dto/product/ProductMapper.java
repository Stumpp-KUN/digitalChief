package com.example.shop.web.dto.product;

import com.example.shop.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private ModelMapper modelMapper=new ModelMapper();

    public Product convertReadDtoToEntity(ProductDTORead dto){
        return modelMapper.map(dto,Product.class);
    }

    public ProductDTORead convertEntityToReadDto(Product product){
        return modelMapper.map(product,ProductDTORead.class);
    }

    public Product convertCreateDtoToEntity(ProductDTOCreate dto){
        return modelMapper.map(dto,Product.class);
    }

    public ProductDTOCreate convertEntityToCreateDto(Product product){
        return modelMapper.map(product,ProductDTOCreate.class);
    }
}

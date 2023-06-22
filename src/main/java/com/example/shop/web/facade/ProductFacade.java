package com.example.shop.web.facade;

import com.example.shop.service.ProductService;
import com.example.shop.web.dto.product.ProductDTOCreate;
import com.example.shop.web.dto.product.ProductDTORead;
import com.example.shop.web.dto.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFacade {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductDTORead getProduct(Long id){
        return productMapper.convertEntityToReadDto(
                productService.getProduct(id));
    }

    public ProductDTOCreate saveProduct(ProductDTOCreate dto){
        return productMapper.convertEntityToCreateDto(
                productService.saveProduct(productMapper.convertCreateDtoToEntity(dto)));
    }

    public ProductDTORead updateProduct(ProductDTORead dto){
        return productMapper.convertEntityToReadDto(
                productService.updateProduct(productMapper.convertReadDtoToEntity(dto)));
    }

    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }
}

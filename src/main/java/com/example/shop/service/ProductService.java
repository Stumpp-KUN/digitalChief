package com.example.shop.service;

import com.example.shop.exception.EntityNotFoundException;
import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new  EntityNotFoundException("There is no product with id "+id));
    }

    @Transactional
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

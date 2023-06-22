package com.example.shop.service;

import com.example.shop.exception.EntityNotFoundException;
import com.example.shop.model.Category;
import com.example.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getCategory(Long id){
        return categoryRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("There is no category with id "+id));
    }

    @Transactional
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    @Transactional
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }
}

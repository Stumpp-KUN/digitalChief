package com.example.shop.web.facade;

import com.example.shop.service.CategoryService;
import com.example.shop.web.dto.category.CategoryDTOCreate;
import com.example.shop.web.dto.category.CategoryDTORead;
import com.example.shop.web.dto.category.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryFacade {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryDTORead getCategory(Long id){
        return categoryMapper.convertEntityToDtoRead(categoryService.getCategory(id));
    }

    public void deleteCategory(Long id){
        categoryService.deleteCategory(id);
    }

    public CategoryDTOCreate createCategory(CategoryDTOCreate dto){
        return categoryMapper.convertEntityToDtoCreate(
                categoryService.createCategory(categoryMapper.convertCreateDtoToEntity(dto)));
    }

    public CategoryDTORead updateCategory(CategoryDTORead dto){
        return categoryMapper.convertEntityToDtoRead(
                categoryService.updateCategory(categoryMapper.convertReadDtoToEntity(dto)));
    }
}

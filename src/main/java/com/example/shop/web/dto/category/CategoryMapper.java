package com.example.shop.web.dto.category;

import com.example.shop.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    private ModelMapper modelMapper=new ModelMapper();

    public Category convertReadDtoToEntity(CategoryDTORead dto){
        return modelMapper.map(dto,Category.class);
    }

    public CategoryDTORead convertEntityToDtoRead(Category entity){
        return modelMapper.map(entity,CategoryDTORead.class);
    }

    public Category convertCreateDtoToEntity(CategoryDTOCreate dto){
        return modelMapper.map(dto,Category.class);
    }

    public CategoryDTOCreate convertEntityToDtoCreate(Category entity){
        return modelMapper.map(entity,CategoryDTOCreate.class);
    }
}

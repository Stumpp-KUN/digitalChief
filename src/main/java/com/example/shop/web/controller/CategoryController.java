package com.example.shop.web.controller;

import com.example.shop.web.dto.category.CategoryDTO;
import com.example.shop.web.dto.category.CategoryDTOCreate;
import com.example.shop.web.dto.category.CategoryDTORead;
import com.example.shop.web.facade.CategoryFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryFacade categoryFacade;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTORead> getCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryFacade.getCategory(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryFacade.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<CategoryDTOCreate> addNewCategory(@RequestBody @Valid CategoryDTOCreate dto){
        return new ResponseEntity<>(categoryFacade.createCategory(dto),HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<CategoryDTORead> updateCategory(@RequestBody @Valid CategoryDTORead dto){
        return new ResponseEntity<>(categoryFacade.updateCategory(dto),HttpStatus.ACCEPTED);
    }
}

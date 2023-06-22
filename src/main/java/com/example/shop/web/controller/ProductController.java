package com.example.shop.web.controller;

import com.example.shop.web.dto.product.ProductDTOCreate;
import com.example.shop.web.dto.product.ProductDTORead;
import com.example.shop.web.facade.CategoryFacade;
import com.example.shop.web.facade.ProductFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductFacade productFacade;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTORead> getProduct(@PathVariable Long id){
        return new ResponseEntity<>(productFacade.getProduct(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductDTOCreate> saveProduct(@RequestBody @Valid ProductDTOCreate productDTOCreate){
        return new ResponseEntity<>(productFacade.saveProduct(productDTOCreate), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ProductDTORead> updateProduct(@RequestBody @Valid ProductDTORead productDTORead){
        return new ResponseEntity<>(productFacade.updateProduct(productDTORead), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productFacade.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

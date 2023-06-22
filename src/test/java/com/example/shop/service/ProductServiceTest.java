package com.example.shop.service;

import com.example.shop.exception.EntityNotFoundException;
import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    public void getProduct_ValidId_ReturnsProduct() {
        Long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        given(productRepository.findById(productId)).willReturn(Optional.of(expectedProduct));

        Product result = productService.getProduct(productId);

        assertThat(result).isEqualTo(expectedProduct);
    }

    @Test
    public void getProduct_InvalidId_ThrowsEntityNotFoundException() {
        Long invalidId = 100L;
        given(productRepository.findById(invalidId)).willReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getProduct(invalidId))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("There is no product with id " + invalidId);
    }

    @Test
    public void saveProduct_ValidProduct_ReturnsSavedProduct() {
        Product productToSave = new Product();
        given(productRepository.save(productToSave)).willReturn(productToSave);

        Product savedProduct = productService.saveProduct(productToSave);

        assertThat(savedProduct).isEqualTo(productToSave);
        verify(productRepository).save(productToSave);
    }

    @Test
    public void updateProduct_ValidProduct_ReturnsUpdatedProduct() {
        Product existingProduct = new Product();
        existingProduct.setId(1L);
        given(productRepository.save(existingProduct)).willReturn(existingProduct);

        Product updatedProduct = productService.updateProduct(existingProduct);

        assertThat(updatedProduct).isEqualTo(existingProduct);
        verify(productRepository).save(existingProduct);
    }

    @Test
    public void deleteProduct_ValidId_DeletesProduct() {
        Long productId = 1L;

        productService.deleteProduct(productId);

        verify(productRepository).deleteById(productId);
    }
}

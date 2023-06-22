package com.example.shop.service;

import com.example.shop.exception.EntityNotFoundException;
import com.example.shop.model.Category;
import com.example.shop.repository.CategoryRepository;
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
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void getCategory_ValidId_ReturnsCategory() {
        Long categoryId = 1L;
        Category expectedCategory = new Category();
        expectedCategory.setId(categoryId);
        given(categoryRepository.findById(categoryId)).willReturn(Optional.of(expectedCategory));

        Category result = categoryService.getCategory(categoryId);

        assertThat(result).isEqualTo(expectedCategory);
    }

    @Test
    public void getCategory_InvalidId_ThrowsEntityNotFoundException() {
        Long invalidId = 100L;
        given(categoryRepository.findById(invalidId)).willReturn(Optional.empty());

        assertThatThrownBy(() -> categoryService.getCategory(invalidId))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("There is no category with id " + invalidId);
    }

    @Test
    public void deleteCategory_ValidId_DeletesCategory() {
        Long categoryId = 1L;

        categoryService.deleteCategory(categoryId);

        verify(categoryRepository).deleteById(categoryId);
    }

    @Test
    public void createCategory_ValidCategory_ReturnsSavedCategory() {
        Category categoryToSave = new Category();
        given(categoryRepository.save(categoryToSave)).willReturn(categoryToSave);

        Category savedCategory = categoryService.createCategory(categoryToSave);

        assertThat(savedCategory).isEqualTo(categoryToSave);
        verify(categoryRepository).save(categoryToSave);
    }

    @Test
    public void updateCategory_ValidCategory_ReturnsUpdatedCategory() {
        Category existingCategory = new Category();
        existingCategory.setId(1L);
        given(categoryRepository.save(existingCategory)).willReturn(existingCategory);

        Category updatedCategory = categoryService.updateCategory(existingCategory);

        assertThat(updatedCategory).isEqualTo(existingCategory);
        verify(categoryRepository).save(existingCategory);
    }
}

package com.eion.restapi.service;

import com.eion.restapi.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto getCategory(Long categoryId);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
    void deleteCategory(long categoryId);
}

package com.eion.restapi.service.impl;

import com.eion.restapi.entity.Category;
import com.eion.restapi.exception.ResourceNotFoundException;
import com.eion.restapi.payload.CategoryDto;
import com.eion.restapi.repository.CategoryRepository;
import com.eion.restapi.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", categoryId));

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) ->
                modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", categoryId));
        category.setId(categoryId);
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        Category updatedCategory = categoryRepository.save(category);

        return modelMapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", categoryId));
        categoryRepository.delete(category);
    }
}

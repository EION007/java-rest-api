package com.eion.restapi.controller;

import com.eion.restapi.payload.CategoryDto;
import com.eion.restapi.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    //Build add category rest api
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.addCategory(categoryDto), HttpStatus.CREATED);
    }

    //Build get Category Rest Api
    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long categoryId) {
        return new ResponseEntity<>(categoryService.getCategory(categoryId), HttpStatus.OK);
    }

    //build get all categories rest api
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    //build update Category API
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                                      @PathVariable Long categoryId) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto, categoryId), HttpStatus.OK);
    }

    @DeleteMapping("{categoryId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }
}

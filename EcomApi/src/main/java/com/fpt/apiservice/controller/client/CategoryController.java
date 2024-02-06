package com.fpt.apiservice.controller.client;

import com.fpt.apiservice.models.Category;
import com.fpt.apiservice.requests.category.CategoryRequest;
import com.fpt.apiservice.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/category")
public record CategoryController(CategoryService categoryService) {
    //get all categories
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return categoryService.getCategories();
    }

    //get single category
    @GetMapping(path = "{categoryId}")
    public ResponseEntity<Category> getSingleCategory(@PathVariable("categoryId") Long id) {
        return categoryService.getSingleCategory(id);
    }

    //create category
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

    //update category
    @PutMapping(path = "{categoryId}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable("categoryId") Long id,
            @RequestBody CategoryRequest request
    ) {
        return categoryService.updateCategory(id, request);
    }

    //delete category
    @DeleteMapping(path = "{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable("categoryId") Long id) {
        return categoryService.deleteCategory(id);
    }
}
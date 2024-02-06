package com.fpt.apiservice.services;

import com.fpt.apiservice.models.Category;
import com.fpt.apiservice.repositories.CategoryRepository;
import com.fpt.apiservice.requests.category.CategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    ////////////////////////////////////////////////////////////////////////////////

    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    public ResponseEntity<Category> getSingleCategory(Long categoryId) {
        Optional<Category> categoryData = categoryRepository.findById(categoryId);
        if (categoryData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(categoryData.get(), HttpStatus.OK);
    }

    public ResponseEntity<Category> createCategory(CategoryRequest request) {
        if(request.parentId() != null && request.parentId() != 0) {
            Optional<Category> parentCategory = categoryRepository.findById(request.parentId());
            if(!parentCategory.isPresent()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        // Tạo category mới
        Category data = Category.builder()
                .name(request.name())
                .slug(toSlug(request.name()))
                .thumbnail(request.thumbnail())
                .parentId(request.parentId())
                .build();

        // Lưu category và trả về kết quả
        return new ResponseEntity<>(categoryRepository.save(data), HttpStatus.OK);
    }

    public ResponseEntity<Category> updateCategory(Long categoryId, CategoryRequest request) {
        Optional<Category> categoryData = categoryRepository.findById(categoryId);
        if (categoryData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (request.name() != null) {
            categoryData.get().setName(request.name());
            categoryData.get().setSlug(toSlug(request.name()));
        }

        if (request.thumbnail() != null) {
            categoryData.get().setThumbnail(request.thumbnail());
        }

        if (request.parentId() != null) {
            if (request.parentId() != null && request.parentId() != 0) {
                Optional<Category> parentCategory = categoryRepository.findById(request.parentId());
                if (parentCategory.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
            categoryData.get().setParentId(request.parentId());

        }

        return new ResponseEntity<>(categoryRepository.save(categoryData.get()), HttpStatus.OK);
    }


    public ResponseEntity deleteCategory(Long categoryId) {
        Optional<Category> categoryData = categoryRepository.findById(categoryId);
        if (categoryData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryRepository.deleteById(categoryId);
        return new ResponseEntity(HttpStatus.OK);
    }
}

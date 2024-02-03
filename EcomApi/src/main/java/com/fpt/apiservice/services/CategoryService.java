package com.fpt.apiservice.services;

import com.fpt.apiservice.models.Category;
import com.fpt.apiservice.repositories.CategoryRepository;
import com.fpt.apiservice.requests.category.CategoryRequest;
import com.fpt.apiservice.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> all() {
        return categoryRepository.findAll();
    }


    /**
     * Create category
     *
     * @param categoryRequest
     * @return
     */
    public Category create(CategoryRequest categoryRequest) {
        ModelMapperUtil<Category, CategoryRequest> mapper = new ModelMapperUtil<>();
        Category category = mapper.mapToModel(categoryRequest, new Category());

        return categoryRepository.save(category);
    }

    /**
     * Get category detail
     *
     * @param id
     * @return
     */
    public Category detail(Long id) {
        return categoryRepository.findById(id).get();
    }


    /**
     * Get category detail
     *
     * @param id
     * @return
     */
    public Category update(CategoryRequest categoryRequest, Long id) {
        Category cate = categoryRepository.findById(id).get();
        if (cate != null) {
            cate.setName(categoryRequest.getName());
            if (categoryRequest.getParentId() != 0) {
                cate.setParentId(categoryRequest.getParentId());
            }

            categoryRepository.saveAndFlush(cate);

            return cate;
        }

        return null;
    }
}

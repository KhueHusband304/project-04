package com.fpt.apiservice.repositories;


import com.fpt.apiservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findBySlug(String slug);

    List<Category> findByParentId(Long parentId);
}
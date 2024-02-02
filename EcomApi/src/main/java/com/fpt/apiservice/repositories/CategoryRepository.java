package com.fpt.apiservice.repositories;


import com.fpt.apiservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
package com.fpt.apiservice.repositories;


import com.fpt.apiservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySlug(String slug);

    List<Product> findByIdInOrderByCreatedByDesc(List<String> idList, Pageable pageable);

    List<Product> findBySlugContainingOrderByCreatedByDesc(String slug, Pageable pageable);

    List<Product> findByCategory_SlugInOrderByCreatedByDesc(List<String> categories, Pageable pageable);

    List<Product> findBySlugContainingAndCategory_SlugInOrderByCreatedByDesc(String slug, List<String> categories, Pageable pageable);
}

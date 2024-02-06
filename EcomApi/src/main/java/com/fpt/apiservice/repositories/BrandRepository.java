package com.fpt.apiservice.repositories;

import com.fpt.apiservice.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BrandRepository  extends JpaRepository<Brand, Long> {
}

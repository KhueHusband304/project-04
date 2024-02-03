package com.fpt.apiservice.repositories;

import com.fpt.apiservice.models.Verify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VerifyRepository extends JpaRepository<Verify, Integer> {
    Verify findByCode(String code);
}

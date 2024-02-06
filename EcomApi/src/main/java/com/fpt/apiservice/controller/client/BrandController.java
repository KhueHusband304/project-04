package com.fpt.apiservice.controller.client;

import com.fpt.apiservice.models.Brand;
import com.fpt.apiservice.requests.brand.BrandRequest;
import com.fpt.apiservice.services.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/brand")

public record BrandController(BrandService brandService) {
    //get all brands
    @GetMapping
    public ResponseEntity<List<Brand>> getBrands() {
        return brandService.getBrands();
    }

    //get single brand
    @GetMapping(path = "{brandId}")
    public ResponseEntity<Brand> getSingleBrand(@PathVariable("brandId") Long id) {
        return brandService.getSingleBrand(id);
    }

    //create brand
    @PostMapping
    public ResponseEntity<Brand> createProduct(@RequestBody BrandRequest brandRequest) {
        return brandService.createBrand(brandRequest);
    }

    //update brand
    @PutMapping(path = "{brandId}")
    public ResponseEntity<Brand> updateBrand(
            @PathVariable("brandId") Long id,
            @RequestBody BrandRequest request
    ) {
        return brandService.updateBrand(id, request);
    }

    //delete brand
    @DeleteMapping(path = "{brandId}")
    public ResponseEntity deleteBrand(@PathVariable("brandId") Long id) {
        return brandService.deleteBrand(id);
    }
}
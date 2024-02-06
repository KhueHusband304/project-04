package com.fpt.apiservice.services;

import com.fpt.apiservice.models.Brand;
import com.fpt.apiservice.repositories.BrandRepository;
import com.fpt.apiservice.requests.brand.BrandRequest;
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
public class BrandService {
    private final BrandRepository brandRepository;

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    ///////////////////////////////////////////////////////////////////////////

    public ResponseEntity<List<Brand>> getBrands() {
        return ResponseEntity.ok(brandRepository.findAll());
    }

    public ResponseEntity<Brand> getSingleBrand(Long brandId) {
        Optional<Brand> brandData = brandRepository.findById(brandId);
        if (brandData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Brand>(brandData.get(), HttpStatus.OK);
    }

    public ResponseEntity<Brand> createBrand(BrandRequest request) {
        Brand brandData = Brand.builder()
                .name(request.name())
                .slug(toSlug(request.name()))
                .thumbnail(request.thumbnail())
                .build();

        return new ResponseEntity<Brand>(
                brandRepository.save(brandData),
                HttpStatus.OK);
    }

    public ResponseEntity<Brand> updateBrand(Long brandId, BrandRequest request) {
        Optional<Brand> brandData = brandRepository.findById(brandId);
        if (brandData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (request.name() != null)
            brandData.get().setName(request.name());
        brandData.get().setSlug(toSlug(request.name()));
        if (request.thumbnail() != null)
            brandData.get().setThumbnail(request.thumbnail());

        return new ResponseEntity<Brand>(brandRepository.save(brandData.get()), HttpStatus.OK);
    }

    public ResponseEntity deleteBrand(Long brandId) {
        Optional<Brand> brandData = brandRepository.findById(brandId);
        if (brandData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        brandRepository.deleteById(brandId);
        return new ResponseEntity(HttpStatus.OK);
    }
}

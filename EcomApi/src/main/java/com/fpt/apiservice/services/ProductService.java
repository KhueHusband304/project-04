package com.fpt.apiservice.services;

import com.fpt.apiservice.models.Brand;
import com.fpt.apiservice.models.Category;
import com.fpt.apiservice.models.Product;
import com.fpt.apiservice.repositories.BrandRepository;
import com.fpt.apiservice.repositories.CategoryRepository;
import com.fpt.apiservice.repositories.ProductRepository;
import com.fpt.apiservice.requests.product.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    ///////////////////////////////////////////////////////////////////////////////

    public ResponseEntity<List<Product>> getProducts(
            List<String> idList,
            String slug,
            String categorySlug,
            Integer page,
            Integer limit
    ) {
        //create category slug list for filter
        List<String> categories = new ArrayList<>();
        if(categorySlug != null) {
            categories.add(categorySlug);

            Category categoryData = categoryRepository.findBySlug(categorySlug);
            if (categoryData != null) {
                List<Category> categoryChildren = categoryRepository.findByParentId(categoryData.getParentId());
                List<String> cateSlugs = categoryChildren.stream()
                        .map(Category::getSlug)
                        .collect(Collectors.toList());
                categories.addAll(cateSlugs);
            }
        }

        //pagination
        Pageable pageableRequest = PageRequest.of(page, limit);

        //find products by slug
        if (slug != null) {
            //find products by slug and categories
            if (!categories.isEmpty()) {
                return ResponseEntity.ok(
                        productRepository.findBySlugContainingAndCategory_SlugInOrderByCreatedByDesc(
                                slug, categories, pageableRequest));
            }

            return ResponseEntity.ok(
                    productRepository.findBySlugContainingOrderByCreatedByDesc(
                            slug, pageableRequest));
        }

        //find products by categories
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(
                    productRepository.findByCategory_SlugInOrderByCreatedByDesc(
                            categories, pageableRequest));
        }

        //find products by id
        if (idList != null) {
            return ResponseEntity.ok(
                    productRepository.findByIdInOrderByCreatedByDesc(
                            idList, pageableRequest));
        }

        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity<Product> getSingleProduct(String productSlug) {
        Optional<Product> productData = productRepository.findBySlug(productSlug);
        if (productData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(productData.get(), HttpStatus.OK);
    }

    public ResponseEntity<Product> createProduct(ProductRequest request, Long userId) {
        //find brand data
        Optional<Brand> brandData = brandRepository.findById(request.brand());
        if (brandData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //find category data
        List<Category> cateList = new ArrayList<>();
        Optional<Category> categoryChild = categoryRepository.findById(request.category());
        if (categoryChild.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cateList.add(categoryChild.get());

        if(categoryChild.get().getParentId() != null) {
            Optional<Category> categoryParent = categoryRepository.findById(categoryChild.get().getParentId());
            if (categoryParent.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            cateList.add(categoryParent.get());
        }

        Product product = Product.builder()
                .name(request.name())
                .slug(toSlug(request.name()))
                .price(request.price())
                .condition(request.condition())
                .description(request.description())
                .quantity(request.quantity())
                .brand(brandData.get())
                .category(categoryChild.get())
                .thumbnail(request.thumbnail())
                .images(request.images())
                .createdBy(userId)
                .updatedBy(userId)
                .build();

        return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
    }

    public ResponseEntity<Product> updateProduct(String productSlug, ProductRequest request, Long userId) {
        //find product data
        Optional<Product> productData = productRepository.findBySlug(productSlug);
        if (productData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //update
        if (request.name() != null) {
            productData.get().setName(request.name());
            productData.get().setSlug(toSlug(request.name()));
        }
        if (request.price() != null) productData.get().setPrice(request.price());
        if (request.condition() != null) productData.get().setCondition(request.condition());
        if (request.description() != null) productData.get().setDescription(request.description());
        if (request.quantity() != null) productData.get().setQuantity(request.quantity());
        if (request.brand() != null) {
            //find brand data
            Optional<Brand> brandData = brandRepository.findById(request.brand());
            if (brandData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productData.get().setBrand(brandData.get());
        }
        if (request.category() != null) {
            //find category data
            List<Category> cateList = new ArrayList<>();
            Optional<Category> categoryChild = categoryRepository.findById(request.category());
            if (categoryChild.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            cateList.add(categoryChild.get());

            if (categoryChild.isPresent() && categoryChild.get().getParentId() != null) {
                Optional<Category> categoryParent = categoryRepository.findById(categoryChild.get().getParentId());
                if (categoryParent.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                cateList.add(categoryParent.get());
            }

            productData.get().setCategory(categoryChild.get());
        }
        if (request.thumbnail() != null) productData.get().setThumbnail(request.thumbnail());
        if (request.images() != null) productData.get().setImages(request.images());
        //productData.get().setUpdatedBy(userId);

        return new ResponseEntity<>(productRepository.save(productData.get()), HttpStatus.OK);
    }

    public ResponseEntity deleteProduct(Long id) {
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

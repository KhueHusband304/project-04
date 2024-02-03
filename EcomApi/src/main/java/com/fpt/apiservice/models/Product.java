package com.fpt.apiservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.List;

public class Product extends Model{

    @Column(name="name")
    private String name;

    @Column(name="slug", unique = true)
    private String slug;

    @Column(name="price")
    @Min(0)
    private BigDecimal price;

    @Column(name="condition")
    private String condition;

    @Column(name="description", columnDefinition = "TEXT")
    private String description;

    @Column(name="quantity")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "brand")
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "category")
    private Category category;

    @Column(name="thumbnail")
    private String thumbnail;

    @Column(name="images")
    @ElementCollection(targetClass=String.class)
    private List<String> images;


}

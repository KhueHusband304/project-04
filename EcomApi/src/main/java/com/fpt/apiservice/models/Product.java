package com.fpt.apiservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_products")
@SQLDelete(sql = "UPDATE tbl_products SET deleted_at = CURRENT_TIMESTAMP, modified_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")

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

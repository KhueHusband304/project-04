package com.fpt.apiservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="slug", unique = true)
    private String slug;

    @Column(name="price")
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

    @NotNull
    @Column(name="createdBy")
    private Long createdBy;

    @CreationTimestamp
    @Column(name="createdDate", nullable = false, updatable = false)
    private Date createdDate;

    @NotNull
    @Column(name="updatedBy")
    private Long updatedBy;

    @UpdateTimestamp
    @Column(name="updatedDate", nullable = false, updatable = true)
    private Date updatedDate;
}
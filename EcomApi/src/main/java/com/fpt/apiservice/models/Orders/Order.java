package com.fpt.apiservice.models.Orders;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_orders")
@Setter @Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="status", columnDefinition = "varchar(255) default 'CART'")
    private String status;

    @Column(name="products")
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderProductItem> products;

    @NotNull
    @Column(name="total")
    private BigDecimal total;

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

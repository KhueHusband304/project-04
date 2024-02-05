package com.fpt.apiservice.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_brands")
@SQLDelete(sql = "UPDATE tbl_brands SET deleted_at = CURRENT_TIMESTAMP, modified_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")

public class Brand extends Model{

    @Column(name="name")
    private String name;

    @Column(name="slug")
    private String slug;

    @Column(name="thumbnail")
    private String thumbnail;
}

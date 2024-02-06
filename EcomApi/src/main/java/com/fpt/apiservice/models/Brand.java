package com.fpt.apiservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "tbl_brands")
@SQLDelete(sql = "UPDATE tbl_brands SET deleted_at = CURRENT_TIMESTAMP, modified_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
public class Brand extends Model {

    private String name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "thumbnail")
    private String thumbnail;
}

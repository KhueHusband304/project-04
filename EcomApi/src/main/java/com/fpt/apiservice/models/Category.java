//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.fpt.apiservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_categories")
@SQLDelete(sql = "UPDATE tbl_categories SET deleted_at = CURRENT_TIMESTAMP, modified_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
public class Category extends Model {
    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Long parentId;
}

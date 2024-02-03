//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.fpt.apiservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
    @LastModifiedDate
    @Column(name = "modified_at")
    private Timestamp modifiedAt;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_by")
    private Long updatedBy;

    @PrePersist
    public void prePersist() {
        this.deletedAt = null;
    }

}

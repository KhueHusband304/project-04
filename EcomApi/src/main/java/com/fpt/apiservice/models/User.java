
package com.fpt.apiservice.models;

import com.fpt.apiservice.types.RoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_users")
@SQLDelete(sql = "UPDATE tbl_users SET deleted_at = CURRENT_TIMESTAMP, modified_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
public class User extends Model {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "role", nullable = true)
    private RoleType role;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @Column(name = "is_verified", nullable = true)
    private boolean isVerified;
}
package com.example.forms_collect.entity;

import com.example.forms_collect.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Data
@Accessors(chain = true)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean expired = false;

    private LocalDate expirationDate;

    @Column(nullable = false)
    private boolean enabled = true;



    @Column(length = 50)
    private String licenceType;

    private String description;

    private String societe;

    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;


    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((GrantedAuthority) () -> "ROLE_" + role.name());
    }


    @Override
    public String getUsername () {
        return email;
    }

    // Compte expiré manuellement OU par date
    @Override
    public boolean isAccountNonExpired() {
        if (expired) return false;
        return expirationDate == null || expirationDate.isAfter(LocalDate.now());
    }

    @Override
    public  boolean  isAccountNonLocked () {
        return  true ;
    }

    @Override
    public  boolean  isCredentialsNonExpired () {
        return  true ;
    }

    @Override
    public  boolean  isEnabled () {
        return  enabled;
    }
}

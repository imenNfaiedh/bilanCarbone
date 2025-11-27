package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
@Table(name = "category_company")
public class CategoryCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "categoryCompany", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Company> companies = new ArrayList<>();
}
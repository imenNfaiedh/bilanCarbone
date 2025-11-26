package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackagingDelivered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packagingDeliveredId;
    private String typeEmballage;
    private Double quantiteTonne;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
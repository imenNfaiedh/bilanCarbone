package com.example.forms_collect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mois;
    private Double quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "combustible_id")
    private Combustible combustible;

}

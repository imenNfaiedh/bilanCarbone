package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Combustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long combustibleId;
    private String type;
    private String unite;
    private Double annualQuantity;
    private String dataAcquisitionMethod;
    private boolean monthlyMonitoring;

    @OneToMany(mappedBy = "combustible", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonthlyData> donneesMensuelles=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

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
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "website")
    private String website;

    @Column(name = "staff_count")
    private Integer staffCount;

    @Column(name = "revenue")
    private Double revenue;

    @Column(name = "office_area")
    private Double officeArea; // Surface bureaux

    @Column(name = "production_area")
    private Double productionArea;

    @Column(name = "year")
    private Integer year;

    @Column(name = "manager")
    private String manager;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Evocation> evocations;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Combustible> combustibles = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FroidBilanMatiere> froidBilanMatieres = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FroidEquipement> froidEquipements = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PackagingDelivered> packagingDeliveredList = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PackagingMaterial> packagingMaterials = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductionWaste> productionWastes = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RawMaterial> rawMaterials = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WaterSupply> waterSupplies = new ArrayList<>();


}


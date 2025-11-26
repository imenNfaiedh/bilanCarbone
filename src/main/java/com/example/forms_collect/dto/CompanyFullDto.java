package com.example.forms_collect.dto;

import com.example.forms_collect.entity.FroidEquipement;
import com.example.forms_collect.entity.PackagingDelivered;
import com.example.forms_collect.entity.PackagingMaterial;
import com.example.forms_collect.entity.ProductionWaste;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyFullDto {
    private CompanyDto company;
    private List<EvocationDto> evocations;
    private List<CombustibleDto> combustibles;
    private List<VehicleDto> vehicles;
    private List<FroidBilanMatiereDto> froidBilanMatieres;
    private List<FroidEquipementDto> froidEquipements;
    private List<PackagingDeliveredDto> packagingDeliveredList;
    private List<PackagingMaterialDto> packagingMaterials;
    private List<ProductionWasteDto> productionWastes;
    private List<RawMaterialDto> rawMaterials;
    private List<WaterSupplyDto> waterSupplies;

}

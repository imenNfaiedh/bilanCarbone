package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.*;
import com.example.forms_collect.entity.*;
import com.example.forms_collect.mapper.*;
import com.example.forms_collect.repository.ICompanyRepository;
import com.example.forms_collect.repository.IEvocationRepository;
import com.example.forms_collect.service.ICompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    private final ICompanyRepository companyRepository;
    private final IEvocationRepository evocationRepository;
    private final IMapperCompany mapperCompany;
    private final IMapperEvocation mapperEvocation;
    private final ICombustibleMapper mapperCombustible;
    private final IVehicleMapper vehicleMapper;
    private  final IFroidBilanMatiereMapper mapperFroidBilan;
    private  final IFroidEquipementMapper froidEquipementMapper;
    private  final IPackagingDeliveredMapper packagingDeliveredMapper;
    private  final IPackagingMaterialMapper packagingMaterialMapper;
    private  final IProductionWasteMapper productionWasteMapper;
    private final IMapperWaterSupply mapperWaterSupply;
    private final IMapperRawMaterial mapperRawMaterial;


    public CompanyService(ICompanyRepository companyRepository,
                          IEvocationRepository evocationRepository,
                          IMapperCompany mapperCompany,
                          IMapperEvocation mapperEvocation, ICombustibleMapper mapperCombustible, IVehicleMapper vehicleMapper, IFroidBilanMatiereMapper mapperFroidBilan, IFroidEquipementMapper froidEquipementMapper, IPackagingDeliveredMapper packagingDeliveredMapper, IPackagingMaterialMapper packagingMaterialMapper, IProductionWasteMapper productionWasteMapper, IMapperWaterSupply mapperWaterSupply, IMapperRawMaterial mapperRawMaterial) {
        this.companyRepository = companyRepository;
        this.evocationRepository = evocationRepository;
        this.mapperCompany = mapperCompany;
        this.mapperEvocation = mapperEvocation;
        this.mapperCombustible = mapperCombustible;
        this.vehicleMapper = vehicleMapper;
        this.mapperFroidBilan = mapperFroidBilan;
        this.froidEquipementMapper = froidEquipementMapper;
        this.packagingDeliveredMapper = packagingDeliveredMapper;
        this.packagingMaterialMapper = packagingMaterialMapper;
        this.productionWasteMapper = productionWasteMapper;
        this.mapperWaterSupply = mapperWaterSupply;
        this.mapperRawMaterial = mapperRawMaterial;
    }

    @Override

    public CompanyFullDto saveCompanyFull(CompanyFullDto dto) {

        Company company = mapperCompany.toEntity(dto.getCompany());

        //evocation
        List<Evocation> evocations = new ArrayList<>();
        for (EvocationDto evoDto : dto.getEvocations()) {
            Evocation ev = mapperEvocation.toEntity(evoDto);
            ev.setCompany(company); // lier l'évocation à la compagnie
            evocations.add(ev);
        }
        company.setEvocations(evocations);

        // Combustibles
        List<Combustible> combustibles = new ArrayList<>();
        for (CombustibleDto combDto : dto.getCombustibles()) {
            Combustible comb = mapperCombustible.toEntity(combDto);
            comb.setCompany(company);

            // les données mensuelles
            if (comb.getDonneesMensuelles() != null) {
                for (MonthlyData md : comb.getDonneesMensuelles()) {
                    md.setCombustible(comb);
                }
            }
            combustibles.add(comb);
        }
        company.setCombustibles(combustibles);

        // Vehicles
        List<Vehicle> vehicles = new ArrayList<>();
        for (VehicleDto vehDto : dto.getVehicles()) {
            Vehicle veh = vehicleMapper.toEntity(vehDto);
            veh.setCompany(company);

            if (veh.getMonthlyData() != null) {
                for (VehicleMonthlyData vmd : veh.getMonthlyData()) {
                    vmd.setVehicle(veh);
                }
            }
            vehicles.add(veh);
        }
        company.setVehicles(vehicles);

        // Froid Bilan Matière
        List<FroidBilanMatiere> fbmList = new ArrayList<>();
        for (FroidBilanMatiereDto fbmDto : dto.getFroidBilanMatieres()) {
            FroidBilanMatiere fbm = mapperFroidBilan.toEntity(fbmDto);
            fbm.setCompany(company);
            fbmList.add(fbm);
        }
        company.setFroidBilanMatieres(fbmList);

        // Froid Equipements

        List<FroidEquipement> feList = new ArrayList<>();
        for (FroidEquipementDto feDto : dto.getFroidEquipements()) {
            FroidEquipement fe = froidEquipementMapper.toEntity(feDto);
            fe.setCompany(company);
            feList.add(fe);
        }
        company.setFroidEquipements(feList);


        // Packaging Delivered

        List<PackagingDelivered> pdList = new ArrayList<>();
        for (PackagingDeliveredDto pdDto : dto.getPackagingDeliveredList()) {
            PackagingDelivered pd = packagingDeliveredMapper.toEntity(pdDto);
            pd.setCompany(company);
            pdList.add(pd);
        }
        company.setPackagingDeliveredList(pdList);


        // Packaging Materials

        List<PackagingMaterial> pmList = new ArrayList<>();
        for (PackagingMaterialDto pmDto : dto.getPackagingMaterials()) {
            PackagingMaterial pm = packagingMaterialMapper.toEntity(pmDto);
            pm.setCompany(company);
            pmList.add(pm);
        }
        company.setPackagingMaterials(pmList);


        // Production Waste

        List<ProductionWaste> pwList = new ArrayList<>();
        for (ProductionWasteDto pwDto : dto.getProductionWastes()) {
            ProductionWaste pw = productionWasteMapper.toEntity(pwDto);
            pw.setCompany(company);
            pwList.add(pw);
        }
        company.setProductionWastes(pwList);

        // 9. RAW MATERIAL

        List<RawMaterial> rmList = new ArrayList<>();
        for (RawMaterialDto rmDto : dto.getRawMaterials()) {
            RawMaterial rm = mapperRawMaterial.toEntity(rmDto);
            rm.setCompany(company);
            rmList.add(rm);
        }
        company.setRawMaterials(rmList);



        // 10. WATER SUPPLY

        List<WaterSupply> wsList = new ArrayList<>();
        for (WaterSupplyDto wsDto : dto.getWaterSupplies()) {
            WaterSupply ws = mapperWaterSupply.toEntity(wsDto);
            ws.setCompany(company);
            wsList.add(ws);
        }
        company.setWaterSupplies(wsList);









        Company saved = companyRepository.save(company);
        CompanyFullDto response = new CompanyFullDto();
        response.setCompany(mapperCompany.toDto(saved));
        response.setEvocations(saved.getEvocations().stream().map(mapperEvocation::toDto).toList());
        response.setCombustibles(saved.getCombustibles().stream().map(mapperCombustible::toDto).toList());
        response.setFroidBilanMatieres(saved.getFroidBilanMatieres().stream().map(mapperFroidBilan::toDto).toList());
        response.setFroidEquipements(saved.getFroidEquipements().stream().map(froidEquipementMapper::toDto).toList());
        response.setPackagingDeliveredList(saved.getPackagingDeliveredList().stream().map(packagingDeliveredMapper::toDto).toList());
        response.setPackagingMaterials(saved.getPackagingMaterials().stream().map(packagingMaterialMapper::toDto).toList());
        response.setProductionWastes(saved.getProductionWastes().stream().map(productionWasteMapper::toDto).toList());
        response.setRawMaterials(saved.getRawMaterials().stream().map(mapperRawMaterial::toDto).toList());
        response.setWaterSupplies(saved.getWaterSupplies().stream().map(mapperWaterSupply::toDto).toList());




        return response;
    }
}

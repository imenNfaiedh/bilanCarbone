package com.example.forms_collect.repository;

import com.example.forms_collect.entity.WaterSupply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWaterSupplyRepository extends CrudRepository<WaterSupply, Long> {

}

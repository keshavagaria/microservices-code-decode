package com.hcl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.demo.entity.VaccinationCenter;

@Repository
public interface VaccinatonCenterRepository extends JpaRepository<VaccinationCenter, Integer>{

}

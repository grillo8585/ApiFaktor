package com.asofi.servrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Riesgo;

@Repository
public interface RiesgosRepository extends JpaRepository<Riesgo, Long>,JpaSpecificationExecutor<Riesgo>{

}

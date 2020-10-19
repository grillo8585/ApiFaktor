package com.asofi.servrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import com.asofi.servrest.entity.Empresa;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresa, Long>,JpaSpecificationExecutor<Empresa>{
 
}

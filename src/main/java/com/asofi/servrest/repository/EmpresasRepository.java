package com.asofi.servrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.asofi.servrest.entity.Empresas;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long>{
 
}

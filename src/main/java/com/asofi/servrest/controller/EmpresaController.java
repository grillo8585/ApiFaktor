package com.asofi.servrest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asofi.servrest.entity.Empresas;
import com.asofi.servrest.service.EmpresasService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

	@Autowired //Realizamos la inyección de dependencias  
	private EmpresasService empresasServices;
	
	//Crear Empresa
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Empresas empresa){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empresasServices.save(empresa));
	}
	
	// Leer una empresa
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Idempresa){
		Optional<Empresas> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oEmpresas);
	}
	
	//Actualizar una empresa
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Empresas empresaDetails,  @PathVariable(value = "id") Long Idempresa){
		Optional<Empresas> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
		}
		
		//Actualizamos los campos
		oEmpresas.get().setNombre(empresaDetails.getNombre());
		oEmpresas.get().setNombre(empresaDetails.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(empresasServices.save(oEmpresas.get()));
		
	}
	//Borrar una empresa
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Idempresa){
		Optional<Empresas> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
		}
		//Borramos el usuario
		empresasServices.deteleById(Idempresa);
		//Devolvemos rspuesta con código 200 = OK
		return ResponseEntity.ok().build();
	}
 }


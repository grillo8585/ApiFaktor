package com.asofi.servrest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
import com.asofi.servrest.entity.Proyectos;
import com.asofi.servrest.service.EmpresasService;
import com.asofi.servrest.service.ProyectosService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresasController {

	@Autowired //Realizamos la inyección de dependencias  
	private EmpresasService empresasServices;
	@Autowired //Realizamos la inyección de dependencias  
	private ProyectosService proyectosServices;
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
	// Consultar Riesgo de líquidez
    @GetMapping("/{id}/riesgoL")
    public ResponseEntity<?> read_riesgo(@PathVariable(value = "id") Long Idempresa){
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
		oEmpresas.get().setL_riesgos(empresaDetails.getL_riesgos());
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
		
		Optional<Proyectos> oProyectos = proyectosServices.findByIDEmpresa(Idempresa);
		oProyectos.get().setEmpresa(null);
		proyectosServices.save(oProyectos.get());
		//Borramos el usuario
		empresasServices.deteleById(Idempresa);
		//Devolvemos rspuesta con código 200 = OK
		return ResponseEntity.ok().build();
	}
	
	//Leer Todas las empresas
	@GetMapping
	public List<Empresas> readAll(){
		//Utilizamos Streamsupport Api Java 8
		
		List<Empresas> empresas = StreamSupport // Usamos streamsupport que hereda de Object 
				.stream(empresasServices.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return empresas;
	}
 }


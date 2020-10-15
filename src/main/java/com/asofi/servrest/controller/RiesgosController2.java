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

import com.asofi.servrest.entity.Riesgos;
import com.asofi.servrest.service.RiesgosService;

@RestController
@RequestMapping("/api/riesgos")
public class RiesgosController2 {

	@Autowired //Realizamos la inyección de dependencias  
	private RiesgosService riesgosServices;
	
	//Crear riesgo
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Riesgos riesgo){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(riesgosServices.save(riesgo));
	}
	
	// Leer una riesgo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Idriesgo){
		Optional<Riesgos> oRiesgos = riesgosServices.findByID(Idriesgo);
		//Validamos que haya encontrado la riesgo
		if(!oRiesgos.isPresent()) {
			//Devolvemos que no ha encontrado la riesgo
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oRiesgos);
	}
	// Leer una riesgo
		@GetMapping("/{id}/riesgoL")
    public ResponseEntity<?> read_riesgo(@PathVariable(value = "id") Long Idriesgo){
			Optional<Riesgos> oRiesgos = riesgosServices.findByID(Idriesgo);
			//Validamos que haya encontrado la riesgo
			if(!oRiesgos.isPresent()) {
				//Devolvemos que no ha encontrado la riesgo
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oRiesgos);
		}
	
	//Actualizar una riesgo
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Riesgos riesgoDetails,  @PathVariable(value = "id") Long Idriesgo){
		Optional<Riesgos> oRiesgos = riesgosServices.findByID(Idriesgo);
		//Validamos que haya encontrado la riesgo
		if(!oRiesgos.isPresent()) {
			//Devolvemos que no ha encontrado la riesgo
			return ResponseEntity.notFound().build();
		}
		
		//Actualizamos los campos
		oRiesgos.get().setNombre(riesgoDetails.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(riesgosServices.save(oRiesgos.get()));
		
	}
	//Borrar una riesgo
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Idriesgo){
		Optional<Riesgos> oRiesgos = riesgosServices.findByID(Idriesgo);
		//Validamos que haya encontrado la riesgo
		if(!oRiesgos.isPresent()) {
			//Devolvemos que no ha encontrado la riesgo
			return ResponseEntity.notFound().build();
		}
		oRiesgos.get().removeRiesgosFromEmpresas();
		//Borramos el usuario
		riesgosServices.deteleById(Idriesgo);
		//Devolvemos rspuesta con código 200 = OK
		return ResponseEntity.ok().build();
	}
	
	//Leer Todas las Riesgos
	@GetMapping
	public List<Riesgos> readAll(){
		//Utilizamos Streamsupport Api Java 8
		
		List<Riesgos> Riesgos = StreamSupport // Usamos streamsupport que hereda de Object 
				.stream(riesgosServices.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Riesgos;
	}
 }


package com.asofi.servrest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Riesgo;
import com.asofi.servrest.service.RiesgoService;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import utils.PagingHeaders;
import utils.PagingResponse;

@RestController
@RequestMapping("/api/riesgos")
public class RiesgosController2 {

	@Autowired //Realizamos la inyección de dependencias  
	private RiesgoService riesgosServices;
	
	//Crear riesgo
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Riesgo riesgo){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(riesgosServices.save(riesgo));
	}
	
	// Leer una riesgo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Idriesgo){
		Optional<Riesgo> oRiesgos = riesgosServices.findByID(Idriesgo);
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
			Optional<Riesgo> oRiesgos = riesgosServices.findByID(Idriesgo);
			//Validamos que haya encontrado la riesgo
			if(!oRiesgos.isPresent()) {
				//Devolvemos que no ha encontrado la riesgo
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oRiesgos);
		}
	
	//Actualizar una riesgo
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Riesgo riesgoDetails,  @PathVariable(value = "id") Long Idriesgo){
		Optional<Riesgo> oRiesgos = riesgosServices.findByID(Idriesgo);
		//Validamos que haya encontrado la riesgo
		if(!oRiesgos.isPresent()) {
			//Devolvemos que no ha encontrado la riesgo
			return ResponseEntity.notFound().build();
		}
		
		//Actualizamos los campos
		oRiesgos.get().setNombre(riesgoDetails.getNombre());
        oRiesgos.get().setConsecutivoRiesgo(riesgoDetails.getConsecutivoRiesgo());
		oRiesgos.get().setProcesoAsociado(riesgoDetails.getProcesoAsociado());
		oRiesgos.get().setDescripcionRiesgo(riesgoDetails.getDescripcionRiesgo());
		oRiesgos.get().setRiesgosAsociados(riesgoDetails.getRiesgosAsociados());
		oRiesgos.get().setCausasRiesgo(riesgoDetails.getCausasRiesgo());
		oRiesgos.get().setFactorRiesgo(riesgoDetails.getFactorRiesgo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(riesgosServices.save(oRiesgos.get()));
		
	}
	//Borrar una riesgo
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Idriesgo){
		Optional<Riesgo> oRiesgos = riesgosServices.findByID(Idriesgo);
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
	
	//Leer Todas las Riesgo
	/*
	 * @GetMapping public List<Riesgo> readAll(){ //Utilizamos Streamsupport Api
	 * Java 8
	 * 
	 * List<Riesgo> Riesgos = StreamSupport // Usamos streamsupport que hereda de
	 * Object .stream(riesgosServices.findAll().spliterator(), false)
	 * .collect(Collectors.toList()); return Riesgos; }
	 */
	@GetMapping
	public ResponseEntity<List<Riesgo>> readAll(
	        @And({
                @Spec(path = "id", params = "id", spec = Equal.class),
                @Spec(path = "nombre", params = "nombre", spec = Like.class),
                @Spec(path = "consecutivoRiesgo", params = "consecutivoRiesgo", spec = Like.class),
                @Spec(path = "procesoAsociado", params = "procesoAsociado", spec = Like.class),
                @Spec(path = "riesgosAsociados", params = "riesgosAsociados", spec = Like.class),
                //@Spec(path = "telefono", params = {"createDateGt", "createDateLt"}, spec = Between.class)
                @Spec(path = "causasRiesgo", params = "causasRiesgo", spec = Like.class),
                @Spec(path = "factorRiesgo", params = "factorRiesgo", spec = Like.class)
                
        }) Specification<Riesgo> spec,
        Sort sort,
        @RequestHeader HttpHeaders headers) {
    final PagingResponse response = riesgosServices.get(spec, headers, sort);
    return new ResponseEntity<>(response.getElementsr(), returnHttpHeaders(response), HttpStatus.OK);
}

    public HttpHeaders returnHttpHeaders(PagingResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        return headers;
    }

 }


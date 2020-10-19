package com.asofi.servrest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.asofi.servrest.entity.Proyecto;
import com.asofi.servrest.service.EmpresaService;
import com.asofi.servrest.service.ProyectoService;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import utils.PagingHeaders;
import utils.PagingResponse;

import org.springframework.data.domain.Sort;
@RestController
@RequestMapping("/api/empresas")
public class EmpresasController {

	@Autowired //Realizamos la inyección de dependencias  
	private EmpresaService empresasServices;
	@Autowired //Realizamos la inyección de dependencias  
	private ProyectoService proyectosServices;
	//Crear Empresa
	@PostMapping
	public ResponseEntity<?> create(@RequestBody List<Empresa> empresa){
		
		
//		return ResponseEntity.status(HttpStatus.CREATED).body(empresasServices.save(empresa)));
		return ResponseEntity.status(HttpStatus.CREATED).body(empresasServices.save(empresa).toArray());
	}
	
	// Leer una empresa
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Idempresa){
		Optional<Empresa> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oEmpresas);
	}
	// 
	//Actualizar una empresa
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Empresa empresaDetails,  @PathVariable(value = "id") Long Idempresa){
		Optional<Empresa> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
		}
		
		//Actualizamos los campos
		oEmpresas.get().setNombre(empresaDetails.getNombre());
		
		oEmpresas.get().setL_riesgos(empresaDetails.getL_riesgos());
		
		oEmpresas.get().setNit(empresaDetails.getNit());
		oEmpresas.get().setDescripcion(empresaDetails.getDescripcion());
		oEmpresas.get().setDireccion(empresaDetails.getDireccion());
		oEmpresas.get().setTelefono(empresaDetails.getTelefono());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empresasServices.save(oEmpresas.get()));
		
	}
	//Borrar una empresa
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Idempresa){
		Optional<Empresa> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
		}
		
		Optional<Proyecto> oProyectos = proyectosServices.findByIDEmpresa(Idempresa);
		//Validamos que haya encontrado el proyecto
		if(oProyectos.isPresent()) {
					
					oProyectos.get().setEmpresa(null);
					proyectosServices.save(oProyectos.get());
		}
		//Borramos el usuario
		empresasServices.deteleById(Idempresa);
		//Devolvemos rspuesta con código 200 = OK
		return ResponseEntity.ok().build();
	}
	
	//Leer Todas las empresas
	@GetMapping
	public ResponseEntity<List<Empresa>> readAll(	
        @And({
                @Spec(path = "id", params = "id", spec = Equal.class),
                @Spec(path = "nombre", params = "nombre", spec = Like.class),
                @Spec(path = "nit", params = "nit", spec = Like.class),
                @Spec(path = "descripcion", params = "descripcion", spec = Like.class),
                @Spec(path = "direccion", params = "direccion", spec = Like.class),
                //@Spec(path = "telefono", params = {"createDateGt", "createDateLt"}, spec = Between.class)
                @Spec(path = "telefono", params = "telefono", spec = Equal.class)
        }) Specification<Empresa> spec,
        Sort sort,
        @RequestHeader HttpHeaders headers) {
    final PagingResponse response = empresasServices.get(spec, headers, sort);
    return new ResponseEntity<>(response.getElements(), returnHttpHeaders(response), HttpStatus.OK);
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
	
	/*
	public List<Empresa> readAll(){
		//Utilizamos Streamsupport Api Java 8
		
		List<Empresa> empresas = StreamSupport // Usamos streamsupport que hereda de Object 
				.stream(empresasServices.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return empresas;
	}*/
 }


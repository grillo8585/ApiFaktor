package com.asofi.servrest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="riesgos")
@XmlRootElement(name="riesgos")
public class Riesgos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7738684523315526844L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	@Column(length = 50)
	private String consecutivoRiesgo;
	@Column(length = 50)
	private String procesoAsociado;
	@Column(length = 50)
	private String descripcionRiesgo;
	@Column(length = 50)
	private String riesgosAsociados;
	@Column(length = 50)
	private String causasRiesgo;
	@Column(length = 50)
	private String factorRiesgo;
	
    //@ManyToOne
    //@JoinColumn(name = "empresas_id")
	@ManyToMany(mappedBy = "l_riesgos")
    private List<Empresas> l_empresa;
	
	@PreRemove
	public void removeRiesgosFromEmpresas() {
	    for (Empresas emp : l_empresa) {
	    	emp.getL_riesgos().remove(this);
	    }
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getConsecutivoRiesgo() {
		return consecutivoRiesgo;
	}

	public void setConsecutivoRiesgo(String consecutivoRiesgo) {
		this.consecutivoRiesgo = consecutivoRiesgo;
	}
	
	public String getProcesoAsociado() {
		return procesoAsociado;
	}

	public void setProcesoAsociado(String procesoAsociado) {
		this.procesoAsociado = procesoAsociado;
	}
	
	public String getDescripcionRiesgo() {
		return descripcionRiesgo;
	}

	public void setDescripcionRiesgo(String descripcionRiesgo) {
		this.descripcionRiesgo = descripcionRiesgo;
	}
	
	public String getRiesgosAsociados() {
		return riesgosAsociados;
	}

	public void setRiesgosAsociados(String riesgosAsociados) {
		this.riesgosAsociados = riesgosAsociados;
	}
	
	public String getCausasRiesgo() {
		return causasRiesgo;
	}

	public void setCausasRiesgo(String causasRiesgo) {
		this.causasRiesgo = causasRiesgo;
	}
	
	public String getFactorRiesgo() {
		return factorRiesgo;
	}

	public void setFactorRiesgo(String factorRiesgo) {
		this.factorRiesgo = factorRiesgo;
	}
}

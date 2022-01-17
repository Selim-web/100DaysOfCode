package com.backend.service.backendservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entity_map")
public class Entity_map {

	@Id
	private Integer id_entity;
	private String type_entity;
	private int id_ecdt;
	private int quant_prod;
	private int quant_cons;
	public int getId_entity() {
		return id_entity;
	}
	public Entity_map() {
		
	}

	
	public void setId_entity(int id_entity) {
		this.id_entity = id_entity;
	}
	public String getType_entity() {
		return type_entity;
	}
	public void setType_entity(String type_entity) {
		this.type_entity = type_entity;
	}
	public int getId_ecdt() {
		return id_ecdt;
	}
	public void setId_ecdct(int id_ecdt) {
		this.id_ecdt = id_ecdt;
	}
	public int getQuant_prod() {
		return quant_prod;
	}
	public void setQuant_prod(int quant_prod) {
		this.quant_prod = quant_prod;
	}
	public int getQuant_cons() {
		return quant_cons;
	}
	public void setQuant_cons(int quant_cons) {
		this.quant_cons = quant_cons;
	}
}

package com.backend.service.backendservice.model;



import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Eco_district {

	@Id
	private Integer id_ecdt;
	private int sum_quant_prod;
	private int sum_quant_cons;
	
	public Eco_district(Integer id_ecdt, int sum_quant_prod, int sum_quant_cons) {
		super();
		this.id_ecdt = id_ecdt;
		this.sum_quant_prod = sum_quant_prod;
		this.sum_quant_cons = sum_quant_cons;
	}
	public Integer getId_ecdt() {
		return id_ecdt;
	}
	public void setId_ecdt(Integer id_ecdt) {
		this.id_ecdt = id_ecdt;
	}

	public int getSum_quant_prod() {
		return sum_quant_prod;
	}
	public void setSum_quant_prod(int sum_quant_prod) {
		this.sum_quant_prod = sum_quant_prod;
	}
	public int getSum_quant_cons() {
		return sum_quant_cons;
	}
	public void setSum_quant_cons(int sum_quant_cons) {
		this.sum_quant_cons = sum_quant_cons;
	}
	public Eco_district() {

	}
	

	
}
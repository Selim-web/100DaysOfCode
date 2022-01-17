package com.backend.service.backendservice.model;

import javax.persistence.*;



@Entity
@Table(name = "production_site")
public class ProductionSite implements Comparable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_site;
    private String name, type, location;
    private Boolean state;
    private Integer total_capacity, production_speed, routing_speed, needed_energy,capacity,financial_cost_per_unity,environmental_cost_per_unity;
    
    public ProductionSite() {}

    

	public ProductionSite(Integer id_site, String name, String type, String location, Integer total_capacity,
			Integer production_speed, Integer routing_speed, Integer needed_energy, Integer capacity, Boolean state,
			Integer financial_cost_per_unity, Integer environmental_cost_per_unity) {
		super();
		this.id_site = id_site;
		this.name = name;
		this.type = type;
		this.location = location;
		this.total_capacity = total_capacity;
		this.production_speed = production_speed;
		this.routing_speed = routing_speed;
		this.needed_energy = needed_energy;
		this.capacity = capacity;
		this.state = state;
		this.financial_cost_per_unity = financial_cost_per_unity;
		this.environmental_cost_per_unity = environmental_cost_per_unity;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public Integer getTotal_capacity() {
		return total_capacity;
	}




	public void setTotal_capacity(Integer total_capacity) {
		this.total_capacity = total_capacity;
	}




	public Integer getProduction_speed() {
		return production_speed;
	}




	public void setProduction_speed(Integer production_speed) {
		this.production_speed = production_speed;
	}




	public Integer getRouting_speed() {
		return routing_speed;
	}




	public void setRouting_speed(Integer routing_speed) {
		this.routing_speed = routing_speed;
	}




	public Integer getNeeded_energy() {
		return needed_energy;
	}




	public void setNeeded_energy(Integer needed_energy) {
		this.needed_energy = needed_energy;
	}




	public Integer getCapacity() {
		return capacity;
	}




	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}




	public Boolean getState() {
		return state;
	}




	public void setState(Boolean state) {
		this.state = state;
	}




	public Integer getFinancial_cost_per_unity() {
		return financial_cost_per_unity;
	}




	public void setFinancial_cost_per_unity(Integer financial_cost_per_unity) {
		this.financial_cost_per_unity = financial_cost_per_unity;
	}




	public Integer getEnvironmental_cost_per_unity() {
		return environmental_cost_per_unity;
	}




	public void setEnvironmental_cost_per_unity(Integer environmental_cost_per_unity) {
		this.environmental_cost_per_unity = environmental_cost_per_unity;
	}




	public Integer getId_site() {
		return id_site;
	}




	@Override
	public int compareTo(Object o) {
		ProductionSite prod_site=(ProductionSite)o;
		if(this.id_site>prod_site.id_site)
			return 1;
		else if(this.id_site<prod_site.id_site)
			return -1;
		return 0;
	}
}

package com.frontend.Model;

public class ProductionSite implements Comparable{
	   
	    private Integer id_site;
	    private String name, type, location;
	    private Integer capacity, production_speed, routing_speed, needed_energy;
	    private Boolean state;

	    public ProductionSite() {}

	    public ProductionSite(String name,
	                          String type,
	                          String location,
	                          Integer capacity,
	                          Integer production_speed,
	                          Integer routing_speed,
	                          Integer needed_energy) {
	        this.name = name;
	        this.type = type;
	        this.location = location;
	        this.capacity = capacity;
	        this.production_speed = production_speed;
	        this.routing_speed = routing_speed;
	        this.needed_energy = needed_energy;
	    }

	    public Integer getId_site() {
	        return id_site;
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

	    public String getLocation() {
	        return location;
	    }

	    public Integer getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(Integer capacity) {
	        this.capacity = capacity;
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

	    public Boolean getState() {
	        return state;
	    }

	    public void setState(Boolean state) {
	        this.state = state;
	    }
	    @Override
		public int compareTo(Object o) {
			ProductionSite comp=(ProductionSite)o;
			if(this.id_site>comp.id_site)
				return 1;
			else if(this.id_site<comp.id_site)
				return -1;
			return 0;
		}
	}

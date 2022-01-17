package com.backend.service.backendservice.model;

import javax.persistence.*;

@Entity
@Table(name = "production")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prod;
    private Integer producted_quantity, financial_cost, environmental_cost;
    private Integer fk_site;
    

    
    @ManyToOne
    @JoinColumn(name = "fk_site", referencedColumnName = "id_site", insertable = false, updatable = false)
    private ProductionSite production_site;
 
    public Integer getFk_site() {
		return fk_site;
	}

	public void setFk_site(Integer fk_site) {
		this.fk_site = fk_site;
	}

	public Production() {}

    public Integer getId_prod() {
        return id_prod;
    }

    public Integer getProducted_quantity() {
        return producted_quantity;
    }

    public void setProducted_quantity(Integer producted_quantity) {
        this.producted_quantity = producted_quantity;
    }

    public Integer getFinancial_cost() {
        return financial_cost;
    }

    public void setFinancial_cost(Integer financial_cost) {
        this.financial_cost = financial_cost;
    }

    public Integer getEnvironmental_cost() {
        return environmental_cost;
    }

    public void setEnvironmental_cost(Integer environmental_cost) {
        this.environmental_cost = environmental_cost;
    }
}

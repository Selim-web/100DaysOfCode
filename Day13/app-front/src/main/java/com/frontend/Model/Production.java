package com.frontend.Model;

import java.io.Serializable;

public class Production implements Serializable,Comparable{

    private Integer id_prod;
    private Integer producted_quantity, financial_cost, environmental_cost;
    private ProductionSite prod_site;
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


	public ProductionSite getProd_site() {
		return prod_site;
	}

	public void setProd_site(ProductionSite prod_site) {
		this.prod_site = prod_site;
	}
	
	@Override
	public int compareTo(Object o) {
		Production prod=(Production)o;
		if(this.prod_site.getId_site()>prod.prod_site.getId_site())
			return 1;
		else if(this.prod_site.getId_site()<prod.prod_site.getId_site())
			return -1;
		return 0;
	}
}

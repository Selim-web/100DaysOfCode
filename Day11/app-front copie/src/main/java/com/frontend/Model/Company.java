package com.frontend.Model;



public class Company implements Comparable{

    
    public Integer id;
    public String name;
    public String location;
    public int nbbuilding;

    public Company(Integer id, String name, String location, int nbbuilding) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.nbbuilding = nbbuilding;
    }

    public Company() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getnbbuilding() {
        return nbbuilding;
    }

    public void setnbbuilding(int nbbuilding) {
        this.nbbuilding = nbbuilding;
    }

	@Override
	public int compareTo(Object o) {
		Company comp=(Company)o;
		if(this.id>comp.id)
			return 1;
		else if(this.id<comp.id)
			return -1;
		return 0;
	}
}

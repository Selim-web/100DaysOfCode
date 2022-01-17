package com.frontend.Model;

public class PlugDwp {

    private Integer id;
    private boolean etat;

    public PlugDwp(){
    }

    public PlugDwp(Integer id, boolean etat) {
        this.id = id;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}

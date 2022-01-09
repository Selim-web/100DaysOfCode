package com.frontend.Model;


public class BlindDwp {

    private Integer id;

    private boolean etat;

    private String mode;

    private int opening;

    public BlindDwp() {
    }

    public BlindDwp(Integer id, boolean etat, String mode, int opening) {
        this.id = id;
        this.etat = etat;
        this.mode = mode;
        this.opening = opening;

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getOpening() {
        return opening;
    }

    public void setOpening(int opening) {
        this.opening = opening;
    }
}



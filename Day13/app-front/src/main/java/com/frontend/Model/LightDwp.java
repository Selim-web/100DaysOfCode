package com.frontend.Model;

public class LightDwp {

    public Integer id;

    public boolean etat;

    public int intensity;

    public String mode;

    public LightDwp(Integer id, boolean etat, int intensity, String mode) {
        this.id = id;
        this.etat = etat;
        this.intensity = intensity;
        this.mode = mode;
    }

    public LightDwp() {
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

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "LightDwp{" +
                "id=" + id +
                ", etat=" + etat +
                ", intensity=" + intensity +
                ", mode='" + mode + '\'' +
                '}';
    }
}

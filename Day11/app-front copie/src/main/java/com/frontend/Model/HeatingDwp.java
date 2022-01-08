package com.frontend.Model;

public class HeatingDwp {

    public Integer id;
    public boolean etat;
    public String mode;
    public int temperature;

    public HeatingDwp(Integer id, boolean etat, String mode, int temperature) {
        this.id = id;
        this.etat = etat;
        this.mode = mode;
        this.temperature = temperature;
    }

    public HeatingDwp() {}

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

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "HeatingDwp{" +
                "id=" + id +
                ", etat=" + etat +
                ", mode='" + mode + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}

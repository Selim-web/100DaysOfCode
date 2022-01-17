package com.frontend.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class RoomDigital {


    private Integer idRoom;

    private String nameRoom;

    private Integer nbrRoom;

    private String floor;

    private LightDwp lightDwp;

    private HeatingDwp heatingDwp;

    public RoomDigital(Integer idRoom, String nameRoom, Integer nbrRoom, String floor, LightDwp lightDwp) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.nbrRoom = nbrRoom;
        this.floor = floor;
        this.lightDwp = lightDwp;
    }

    public RoomDigital() {
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String name) {
        this.nameRoom = name;
    }

    public Integer getNbrRoom() {
        return nbrRoom;
    }

    public void setNbrRoom(Integer nbrRoom) {
        this.nbrRoom = nbrRoom;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public LightDwp getLightDwp() {
        return lightDwp;
    }

    public void setLightDwp(LightDwp lightDwp) {
        this.lightDwp = lightDwp;
    }

    public HeatingDwp getHeatingDwp() {
        return heatingDwp;
    }

    public void setHeatingDwp(HeatingDwp heatingDwp) {
        this.heatingDwp = heatingDwp;
    }

    @Override
    public String toString() {
        return "RoomDigital{" +
                "idRoom=" + idRoom +
                ", nameRoom='" + nameRoom + '\'' +
                ", nbrRoom=" + nbrRoom +
                ", floor='" + floor + '\'' +
                '}';
    }
}

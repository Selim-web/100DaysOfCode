package com.frontend.Model;

public class heating {
    private Integer id_heating;
    private Integer temperature;
    private Integer id_room;
    private String state;
    private String auto;

    public Integer getId_heating() {return id_heating;}

    public void setId_heating(Integer id_heating) {this.id_heating = id_heating;}

    public Integer getTemperature() {return temperature;}

    public void setTemperature(Integer temperature) {this.temperature = temperature;}

    public Integer getId_room() {return id_room;}

    public void setId_room(Integer id_room) {this.id_room = id_room;}

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}

    public String getAuto() {return auto;}

    public void setAuto(String auto) {this.auto = auto;}

    public heating(){
    }


}

package com.backend.service.backendservice.model;

import javax.persistence.*;

@Entity
@Table(name="lights")
public class lights {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_light;
    private Integer intensity;
    private Integer id_room;

    public lights(Integer id_light, Integer intensity, Integer id_room) {
        this.id_light = id_light;
        this.intensity = intensity;
        this.id_room = id_room;
    }


    public Integer getId_light() {return id_light;}

    public void setId_light(Integer id_light) {this.id_light = id_light;}

    public Integer getIntensity() {return intensity;}

    public void setIntensity(Integer intensity) {this.intensity = intensity;}

    public Integer getId_room() {return id_room;}

    public void setId_room(Integer id_room) {this.id_room = id_room;}





}

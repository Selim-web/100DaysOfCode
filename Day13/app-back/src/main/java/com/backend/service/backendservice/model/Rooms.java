package com.backend.service.backendservice.model;

import javax.persistence.*;

@Entity
@Table(name="rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_room;
    private String room_type;
    private Integer id_home;


    public Rooms(Integer id_room, String room_type, Integer id_home) {
        this.id_room = id_room;
        this.room_type = room_type;
        this.id_home = id_home;
    }

  public Rooms(){}

    public Integer getId_room() {return id_room;}

    public void setId_room(Integer id_room) {this.id_room = id_room;}

    public String getRoom_type() {return room_type;}

    public void setRoom_type(String room_type) {this.room_type = room_type;}

    public Integer getId_home() {return id_home;}

    public void setId_home(Integer id_home) {this.id_home = id_home;}




}

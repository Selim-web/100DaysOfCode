package com.backend.service.backendservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="room_dwp")
public class RoomDwp {

    @Id
    @SequenceGenerator(
            name = "room_dwp_sequence",
            sequenceName = "room_dwp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "room_dwp_sequence"
    )
    private Long id_room;
    @Column(name="room_type")
    private String room_type;

    //@JsonManagedReference
   // @OneToOne(mappedBy = "roomDwp")
   // private LightDwp lightDwp;

    public RoomDwp (String room_type, Integer id_home) {
        this.room_type = room_type;

    }

    public RoomDwp(){}

    public Long getId_room() {return id_room;}

    public void setId_room(Long id_room) {this.id_room = id_room;}

    public String getRoom_type() {return room_type;}

    public void setRoom_type(String room_type) {this.room_type = room_type;}

   // public LightDwp getLightDwp() {
   //     return lightDwp;
    //}

   // public void setLightDwp(LightDwp lightDwp) {
     //   this.lightDwp = lightDwp;
   // }

    @Override
    public String toString() {
        return "RoomDwp{" +
                "id_room=" + id_room +
                ", room_type='" + room_type + '\'' +
                '}';
    }
}


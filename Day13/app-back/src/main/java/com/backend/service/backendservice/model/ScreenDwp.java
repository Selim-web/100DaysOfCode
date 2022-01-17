package com.backend.service.backendservice.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="screen_dwp")
public class ScreenDwp {
    @Id
    @SequenceGenerator(
            name = "screen_dwp_sequence",
            sequenceName = "screen_dwp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "screen_dwp_sequence"
    )
    private Integer id;
    @Column(name="etat")
    private boolean etat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id_room")
    @JsonBackReference
    private RoomDigital roomDigital;

    public ScreenDwp() {
    }

    public ScreenDwp(Integer id, boolean etat, RoomDigital roomDigital) {
        this.id = id;
        this.etat = etat;
        this.roomDigital = roomDigital;
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

    public RoomDigital getRoomDigital() {
        return roomDigital;
    }

    public void setRoomDigital(RoomDigital roomDigital) {
        this.roomDigital = roomDigital;
    }
}

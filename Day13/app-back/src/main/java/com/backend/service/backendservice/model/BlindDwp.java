package com.backend.service.backendservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="blind_dwp")
public class BlindDwp {
    @Id
    @SequenceGenerator(
            name = "blind_dwp_sequence",
            sequenceName = "blind_dwp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "blind_dwp_sequence"
    )
    private Integer id;
    @Column(name="etat")
    private boolean etat;
    @Column(name = "mode")
    private String mode;
    @Column(name="opening")
    private int opening;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id_room")
    @JsonBackReference
    private RoomDigital roomDigital;

    public RoomDigital getRoomDigital() {
        return roomDigital;
    }

    public void setRoomDigital(RoomDigital roomDigital) {
        this.roomDigital = roomDigital;
    }

    public BlindDwp() {
    }

    public BlindDwp(Integer id, boolean etat, String mode, int opening, RoomDigital roomDigital) {
        this.id = id;
        this.etat = etat;
        this.mode = mode;
        this.opening = opening;
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


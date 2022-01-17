package com.backend.service.backendservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="light_dwp")
public class LightDwp {
    @Id
    @SequenceGenerator(
            name = "light_dwp_sequence",
            sequenceName = "ligth_dwp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "light_dwp_sequence"
    )
    private Integer id;
    @Column(name="etat")
    private boolean etat;
    @Column(name = "mode")
    private String mode;
    @Column(name="intensity")
    private int intensity;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "room_id", referencedColumnName = "id_room")
   @JsonBackReference
   private RoomDigital roomDigital;

    public LightDwp(Integer id, boolean etat, String mode, int intensity, RoomDigital roomDigital) {
        this.id = id;
        this.etat = etat;
        this.mode = mode;
        this.intensity = intensity;
        this.roomDigital = roomDigital;
    }

    public LightDwp() {
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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

    public RoomDigital getRoomDigital() {
        return roomDigital;
    }

    public void setRoomDigital(RoomDigital roomDigital) {
        this.roomDigital = roomDigital;
    }

    @Override
    public String toString() {
        return "LightDwp{" +
                "id=" + id +
                ", etat=" + etat +
                ", mode='" + mode + '\'' +
                ", intensity=" + intensity +
                ", roomDigital=" + roomDigital +
                '}';
    }
}

package test.selim.spring.tuto.testback.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_room")
    private Integer idRoom;
    @Column(name = "name")
    private String nameRoom;
    @Column(name = "nbr_room")
    private Integer nbrRoom;
    @Column(name = "floor")
    private String floor;

    /*@JsonManagedReference
    @OneToOne(mappedBy = "roomDigital")
    private LightDwp lightDwp;
*/
    @JsonManagedReference
    @OneToOne(mappedBy = "roomDigital")
    private HeatingDwp heatingDwp;

  /*  @JsonManagedReference
    @OneToOne(mappedBy = "roomDigital")
    private BlindDwp blindDwp;

    @JsonManagedReference
    @OneToOne(mappedBy = "roomDigital")
    private ScreenDwp screenDwp;

    @JsonManagedReference
    @OneToOne(mappedBy = "roomDigital")
    private PlugDwp plugDwp;*/

    public RoomDigital(Integer idRoom, String nameRoom, Integer nbrRoom, String floor) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.nbrRoom = nbrRoom;
        this.floor = floor;
    }

    public RoomDigital() {
    }

    /**
     * @return Integer return the idRoom
     */
    public Integer getIdRoom() {
        return idRoom;
    }

    /**
     * @param idRoom the idRoom to set
     */
    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    /**
     * @return String return the name
     */
    public String getNameRoom() {
        return nameRoom;
    }

    /**
     * @param name the name to set
     */
    public void setNameRoom(String name) {
        this.nameRoom = name;
    }

    /**
     * @return Integer return the nbrRoom
     */
    public Integer getNbrRoom() {
        return nbrRoom;
    }

    /**
     * @param nbrRoom the nbrRoom to set
     */
    public void setNbrRoom(Integer nbrRoom) {
        this.nbrRoom = nbrRoom;
    }

    /**
     * @return String return the floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

   /* public LightDwp getLightDwp() {
        return lightDwp;
    }

    public void setLightDwp(LightDwp lightDwp) {
        this.lightDwp = lightDwp;
    }*/

    public HeatingDwp getHeatingDwp() {
        return heatingDwp;
    }

    public void setHeatingDwp(HeatingDwp heatingDwp) {
        this.heatingDwp = heatingDwp;
    }
/*
    public BlindDwp getBlindDwp() {
        return blindDwp;
    }

    public void setBlindDwp(BlindDwp blindDwp) {
        this.blindDwp = blindDwp;
    }*/

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


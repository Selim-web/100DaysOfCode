package com.backend.service.backendservice.model;

import javax.persistence.*;


@Entity
@Table(name = "habitation")
public class Habitation  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String adresse;
    private Integer id_user;



    //private Integer door_floor;

    public Habitation(Integer id_home, String type, String adresse, Integer id_user){
        this.id = id_home;
        this.type = type;
        this.adresse = adresse;
        this.id_user = id_user;
    }

    public Habitation(){}

    public Integer getId_home() {return id;}

    public void setId_home(Integer id) {this.id = id;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public String getAdress() {return adresse;}

    public void setAdress(String adress) {this.adresse = adress;}

    public Integer getId_user() {return id_user;}

    public void setId_user(Integer id_user) {this.id_user = id_user;}

}

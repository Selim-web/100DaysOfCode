package com.backend.service.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(FavorisPk.class)
@Table(name = "favoris")
public class Favoris {
    @Id
    @Column(name = "id_person1")
    private Integer idPerson1;
    @Id
    @Column(name = "id_person2")
    private Integer idPerson2;

    public Favoris() {
    }

    /**
     * @return Integer return the idPerson1
     */
    public Integer getIdPerson1() {
        return idPerson1;
    }

    /**
     * @param idPerson1 the idPerson1 to set
     */
    public void setIdPerson1(Integer idPerson1) {
        this.idPerson1 = idPerson1;
    }

    /**
     * @return Integer return the idPerson2
     */
    public Integer getIdPerson2() {
        return idPerson2;
    }

    /**
     * @param idPerson2 the idPerson2 to set
     */
    public void setIdPerson2(Integer idPerson2) {
        this.idPerson2 = idPerson2;
    }

}

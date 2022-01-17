package com.backend.service.backendservice.model;

import java.io.Serializable;

public class FavorisPk implements Serializable {
    protected Integer idPerson1;
    protected Integer idPerson2;

    public FavorisPk() {
    }

    public FavorisPk(Integer idPerson1, Integer idPerson2) {
        this.idPerson2 = idPerson2;
        this.idPerson1 = idPerson1;
    }
}

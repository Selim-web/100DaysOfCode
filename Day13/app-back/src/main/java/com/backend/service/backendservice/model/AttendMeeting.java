package com.backend.service.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attend")
public class AttendMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attend")
    private Integer idAttend;
    @Column(name = "id_booking")
    private Integer idBooking;
    @Column(name = "id_employee")
    private int idPerson;

    public AttendMeeting() {
    }

    public AttendMeeting(Integer id, Integer idPerson, Integer idBooking) {
        this.idAttend = id;
        this.idBooking = idBooking;
        this.idPerson = idPerson;

    }

    /**
     * @return Integer return the idAttend
     */
    public Integer getIdAttend() {
        return idAttend;
    }

    /**
     * @param idAttend the idAttend to set
     */
    public void setIdAttend(Integer idAttend) {
        this.idAttend = idAttend;
    }

    /**
     * @return Integer return the idBooking
     */
    public Integer getIdBooking() {
        return idBooking;
    }

    /**
     * @param idBooking the idBooking to set
     */
    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    /**
     * @return int return the idPerson
     */
    public int getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

}

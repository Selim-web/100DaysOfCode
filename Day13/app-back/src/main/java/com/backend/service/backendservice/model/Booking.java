package com.backend.service.backendservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private Integer idBooking;
    @Column(name = "id_person")
    private int idPerson;
    @Column(name = "id_room")
    private int idRoom;
    @Column(name = "start_time")
    private Time start;
    @Column(name = "end_time")
    private Time end;
    @Column(name = "day")
    private LocalDate date;
    @Column(name = "title_event")
    private String title;

    public Booking() {
    }

    public Booking(int id, LocalDate date, Time start, Time end, Integer idPerson, Integer idRoom) {
        this.idBooking = id;
        this.idPerson = idPerson;
        this.idRoom = idRoom;
        this.date = date;
        this.start = start;
        this.end = end;
    }

    public Booking(int id, LocalDate date, Time start, Time end, Integer idPerson, Integer idRoom, String title) {
        this.idBooking = id;
        this.idPerson = idPerson;
        this.idRoom = idRoom;
        this.date = date;
        this.start = start;
        this.end = end;
        this.title = title;
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

    /**
     * @return int return the idRoom
     */
    public int getIdRoom() {
        return idRoom;
    }

    /**
     * @param idRoom the idRoom to set
     */
    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    /**
     * @return Time return the start
     */
    public Time getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Time start) {
        this.start = start;
    }

    /**
     * @return Time return the end
     */
    public Time getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Time end) {
        this.end = end;
    }

    /**
     * @return LocalDate return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}

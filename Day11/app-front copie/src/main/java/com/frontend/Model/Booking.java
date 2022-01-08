package com.frontend.Model;

public class Booking {
    private String idPerson;
    private String idRoom;
    private String start;
    private String end;
    private String date;
    private String title;

    public Booking(String date, String start, String end, String idPerson, String idRoom) {
        this.idPerson = idPerson;
        this.idRoom = idRoom;
        this.date = date;
        this.start = start;
        this.end = end;
    }

    public Booking(String date, String start, String end, String idPerson, String idRoom, String title) {
        this.idPerson = idPerson;
        this.idRoom = idRoom;
        this.date = date;
        this.start = start;
        this.end = end;
        this.title = title;
    }

    /**
     * @return String return the idPerson
     */
    public String getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * @return String return the idRoom
     */
    public String getIdRoom() {
        return idRoom;
    }

    /**
     * @param idRoom the idRoom to set
     */
    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    /**
     * @return String return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return String return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return String return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the day to set
     */
    public void setDate(String date) {
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

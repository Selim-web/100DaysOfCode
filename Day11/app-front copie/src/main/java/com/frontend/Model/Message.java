package com.frontend.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Message {

    private Integer idMessage;
    private int idSender;
    private int idReceiver;
    private String msg;
    private LocalDate dateSend;
    private LocalTime timeSend;
    private String dateWithTime;

    public Message() {
    }

    /**
     * @return int return the id
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * @param id the id to set
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * @return int return the idSender
     */
    public int getIdSender() {
        return idSender;
    }

    /**
     * @param idSender the idSender to set
     */
    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    /**
     * @return int return the idReceiver
     */
    public int getIdReceiver() {
        return idReceiver;
    }

    /**
     * @param idReceiver the idReceiver to set
     */
    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    /**
     * @return String return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return LocalDate return the dateSend
     */
    public LocalDate getDateSend() {
        return dateSend;
    }

    /**
     * @param dateSend the dateSend to set
     */
    public void setDateSend(LocalDate dateSend) {
        this.dateSend = dateSend;
    }

    /**
     * @return LocalTime return the timeSend
     */
    public LocalTime getTimeSend() {
        return timeSend;
    }

    /**
     * @param timeSend the timeSend to set
     */
    public void setTimeSend(LocalTime timeSend) {
        this.timeSend = timeSend;
    }

    /**
     * @return String return the dateWithTime
     */
    public String getDateWithTime() {
        this.dateWithTime = dateSend + ", " + timeSend;
        return dateWithTime;
    }

    /**
     * @param dateWithTime the dateWithTime to set
     */
    public void setDateWithTime(String dateWithTime) {
        this.dateWithTime = dateWithTime;
    }

}
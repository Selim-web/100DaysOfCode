package com.backend.service.backendservice.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_message")
    private Integer idMessage;
    @Column(name = "id_sender")
    private int idSender;
    @Column(name = "id_receiver")
    private int idReceiver;
    private String msg;
    @Column(name = "date_send")
    private LocalDate dateSend;
    @Column(name = "time_send")
    private LocalTime timeSend;

    public Message() {
    }

    /**
     * @return int return the id
     */
    @Id
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

}
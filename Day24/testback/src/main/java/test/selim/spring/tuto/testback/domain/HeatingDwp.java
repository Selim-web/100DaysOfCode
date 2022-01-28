package test.selim.spring.tuto.testback.domain;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="heating_dwp")
public class HeatingDwp {
    @Id
    @SequenceGenerator(
            name = "heating_dwp_sequence",
            sequenceName = "heating_dwp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "heating_dwp_sequence"
    )
    private Integer id;
    @Column(name = "etat")
    private boolean etat;
    @Column(name = "mode")
    private String mode;
    @Column(name = "temperature")
    private int temperature;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id_room")
    @JsonBackReference
    private RoomDigital roomDigital;

    public HeatingDwp(Integer id,boolean etat, String mode, int temperature, RoomDigital roomDigital) {
        this.id = id;
        this.etat = etat;
        this.mode = mode;
        this.temperature = temperature;
        this.roomDigital = roomDigital;
    }

    public HeatingDwp() {
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public RoomDigital getRoomDigital() {
        return roomDigital;
    }

    public void setRoomDigital(RoomDigital roomDigital) {
        this.roomDigital = roomDigital;
    }

    @Override
    public String toString() {
        return "HeatingDwp{" +
                "id=" + id +
                ", etat=" + etat +
                ", mode='" + mode + '\'' +
                ", temperature=" + temperature +
                ", roomDigital=" + roomDigital +
                '}';
    }
}


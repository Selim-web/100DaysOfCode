Entity Models :

// I have created two OneToOne relationships between a room entity and two other pieces of equipment that a room owns. 

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
    @Column(name = "type_room")
    private String typeRoom;

    @JsonManagedReference
    @OneToOne(mappedBy = "roomDigital")
    private HeatingDwp heatingDwp;

    @JsonManagedReference
    @OneToOne(mappedBy = "roomDigital")
    private BlindDwp blindDwp;



@Entity
@Table(name="blind_dwp")
public class BlindDwp {
    @Id
    private Integer id;
    @Column(name="etat")
    private boolean etat;
    @Column(name = "mode")
    private String mode;
    @Column(name="opening")
    private int opening;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id_room")
    @JsonBackReference
    private RoomDigital roomDigital;

    public RoomDigital getRoomDigital() {
        return roomDigital;
    }

    public void setRoomDigital(RoomDigital roomDigital) {
        this.roomDigital = roomDigital;
    }

    public BlindDwp() {
    }




@Entity
@Table(name="heating_dwp")
public class HeatingDwp {
    @Id
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



package  com.frontend.Model;


public class Power {


 
 private Integer id;

 private String equipmentName;
 private String roomName;
 private String habitationName;
 private Integer power;

 

 
 

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the equipmentName
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * @param equipmentName the equipmentName to set
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * @return String return the roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * @return String return the habitationName
     */
    public String getHabitationName() {
        return habitationName;
    }

    /**
     * @param habitationName the habitationName to set
     */
    public void setHabitationName(String habitationName) {
        this.habitationName = habitationName;
    }

    /**
     * @return Integer return the power
     */
    public Integer getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(Integer power) {
        this.power = power;
    }

}

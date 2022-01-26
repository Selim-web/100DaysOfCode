inside service : 

//The first method allows to check the outside temperature and to adapt the setpoint temperature according to the outside temperature in relation to the room.

  @Scheduled(fixedRate = 60000)
   public void CheckOutdoorTempForAutoMode() {
        List <HeatingDwp> heatingDwpList = heatingDwpRepo.findAll();
       for (HeatingDwp h: heatingDwpList) {
           Integer temp_ext = heatingDwpRepo.getScenario(h.getId().intValue());
           if(h.isEtat()==true) {
               if(h.getMode().equals("automatique")) {
                   System.out.println("Auto mode detected for Heating in room_id = "+h.getId());
                   if (temp_ext > 20) {
                       h.setEtat(false);
                       System.out.println("Heater tuned off in room_id"+h.getId());
                   }
               }
           }
       }
    }

    //The second method allows to vary the indoor temperature according to the set temperature

    public void UpdateInsideTemp() {
        List <HeatingDwp> heatingDwpList = heatingDwpRepo.findAll();
        for (HeatingDwp h: heatingDwpList) {
            if(h.isEtat()==true){
                Integer temp_consigne = h.getTemperature();
                Integer temp_interieur = heatingDwpRepo.getInsideTemperature(h.getId().intValue());
                if(temp_interieur < temp_consigne) {
                    temp_interieur = temp_interieur + 1;
                    heatingDwpRepo.updateInsideTemperature(temp_interieur.intValue(), h.getId().intValue());
                }
                if(temp_interieur > temp_consigne) {
                    temp_interieur = temp_interieur - 1;
                    heatingDwpRepo.updateInsideTemperature(temp_interieur.intValue(), h.getId().intValue());
                }
            }
        }
    }





inside repository : 

@Repository

public interface HeatingDwpRepo extends JpaRepository<HeatingDwp, Integer> {
    @Query(value = "select temperature_ext from scenario where id=?1", nativeQuery=true)
    Integer getScenario(int id);

    @Transactional
    @Modifying
    @Query(value = "update heating_dwp set temperature=?1 where mode='automatique' and etat='true'", nativeQuery = true)
    public void updateTemperature(int temperature);

    @Transactional
    @Modifying
    @Query(value = "update scenario set temperature_int=?1 where id=?2", nativeQuery = true)
    public void updateInsideTemperature(int temperature, int id);

    @Query(value = "select temperature_int from scenario where id=?1", nativeQuery=true)
    Integer getInsideTemperature(int id);

}
Inside Repo :  
    @Transactional
    @Modifying
    @Query(value = "update heating_dwp set temperature=?1 where mode='automatique' and etat='true'", nativeQuery = true)
    public void updateTemperature(int temperature);

Inside Service : 

 public void CheckOutdoorTemp() {
        Integer temp_exterieur = heatingDwpRepo.getScenario();
        Integer temp_int = temp_exterieur + 7;
        Integer temp_consigne = 0;
        if(temp_int < 19)
            temp_consigne = 20;
        if( temp_int >=20 )
            temp_consigne = 7;
        heatingDwpRepo.updateTemperature(temp_consigne);
    }

Inside Controller : 

 @Scheduled(fixedRate = 60000)
    public void checkTemp() {
        heatingDwpService.CheckOutdoorTemp();
        System.out.println("temperature checked");
    }
//inside service : 

    @Scheduled(fixedRate = 60000)
   public void CheckOutdoorTempForAutoMode() {
        List <HeatingDwp> heatingDwpList = heatingDwpRepo.findAll();
       for (HeatingDwp h: heatingDwpList) {
           Integer temp_ext = heatingDwpRepo.getScenario(h.getId().intValue());
           if(h.getMode().equals("automatique")){
               if(temp_ext > 20){
                   if(h.isEtat()){
                       h.setEtat(false);
                       h.setTemperature(7);
                       heatingDwpRepo.save(h);
                       System.out.println("Heater tuned off in room_id = "+h.getId());
                   }
               }
           }
       }
    }

    @Scheduled(fixedRate = 60000)
    public void UpdateInsideTemp() {
        List <HeatingDwp> heatingDwpList = heatingDwpRepo.findAll();
        for (HeatingDwp h: heatingDwpList) {
            if(h.isEtat()==true){
                Integer temp_consigne = h.getTemperature();
                Integer temp_interieur = heatingDwpRepo.getInsideTemperature(h.getId().intValue());
                if(temp_interieur < temp_consigne) {
                    temp_interieur = temp_interieur + 1;
                    heatingDwpRepo.updateInsideTemperature(temp_interieur.intValue(), h.getId().intValue());
                    System.out.println("Inside temperature update in room_id = "+h.getId());
                }
                if(temp_interieur > temp_consigne) {
                    temp_interieur = temp_interieur - 1;
                    heatingDwpRepo.updateInsideTemperature(temp_interieur.intValue(), h.getId().intValue());
                    System.out.println("Inside temperature update in room_id = "+h.getId());
                }
            }
        }
    }

//inside repo : no change with code in day21. 
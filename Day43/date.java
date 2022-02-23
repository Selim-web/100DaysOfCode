 /*
        In winter between 00:00 and 05:00 the outside temperature does not change
        In winter between 05:00 and 08:00 the outside temperature increases by 0.5 degree every hour
        In winter between 08:00 and 17:00 the outside temperature increases by 1 degree every hour for BFN
        In winter between 08:00 and 17:00 the outside temperature increases by 2 degree every hour for BFS
        In winter between 17:00 and 00:00 the outside temperature drops by 1 degree every hour
         */
        Timestamp timestamp = Timestamp.valueOf(date);
        LocalDate day = date.toLocalDate();
        String midnight, five, eight, seventeen;
        midnight = day + "T00:00:00";
        five = day + "T05:00:00";
        eight = day + "T08:00:00";
        seventeen = day + "T17:00:00";

        LocalDateTime midnightTime = LocalDateTime.parse(midnight);
        LocalDateTime fiveTime = LocalDateTime.parse(five);
        LocalDateTime eightTime = LocalDateTime.parse(eight);
        LocalDateTime seventeenTime = LocalDateTime.parse(seventeen);

        Timestamp minuit = Timestamp.valueOf(midnightTime);
        Timestamp cinqheure = Timestamp.valueOf(fiveTime);
        Timestamp huitheure = Timestamp.valueOf(eightTime);
        Timestamp dixseptheure = Timestamp.valueOf(seventeenTime);

        List<HeatingDwp> heatingDwpList = heatingDwpRepo.findAll();
        for (HeatingDwp heatingDwp : heatingDwpList) {
            Integer temp_ext = heatingDwpRepo.getScenario(heatingDwp.getId());
            Integer temp_int = heatingDwpRepo.getInsideTemperature(heatingDwp.getId());
            if(timestamp.after(minuit) && timestamp.before(cinqheure)){
                logger.info("Nous sommes entre 00:00 et 05:00, la température extérieur n'évolue pas");
            }
            if(timestamp.after(cinqheure) && timestamp.before(huitheure)) {
                logger.info("Nous sommes entre 05:00 et 08:00, la température extérieur évolue de 0.5°C");
            }
            if(timestamp.after(huitheure) && timestamp.before(dixseptheure)) {
                // add condition with BFN and BFS
                logger.info("Nous sommes entre 08:00 et 17:00, la température extérieur évolue de 1°C");
            }
            if(timestamp.after(dixseptheure) && timestamp.before(minuit)) {
                logger.info("Nous sommes entre 17:00 et 00:00, la température extérieur diminue de 1°C");
            }
        }
@Service :


@Service
public class ConsumptionDwpService {

    @Autowired
    ConsumptionDwpRepo consumptionDwpRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    HeatingDwpService heatingDwpService;

    LocalDateTime date = LocalDateTime.of(2022,02,04,00,00,00);

    public LocalDateTime getdate() {
        return date;
    }

    public void setdate(LocalDateTime date) {
        this.date = date;
    }

    public void ForThisRoomAndEmployee(Integer employeeId, List<Integer> room_idList, LocalDate date){
        for (Integer id_room: room_idList) {
            for(Integer i = 1; i < 4; i++) {
                //condition si en base on a déjà une ligne en rapport avec cette pièce, cette employé et cette id_equipement
                if(consumptionDwpRepo.checkIfDateIsInTable(id_room,employeeId,i) != null) {
                    // calcul de l'energie
                    Integer energyBeforeCalcul = consumptionDwpRepo.selectEnergy(id_room, employeeId, i, date);
                    Integer energy = CalculationEnergyConsumed(i, id_room, energyBeforeCalcul);
                    //update en base
                    if(energy != 0){
                        consumptionDwpRepo.UpdateConsumptionDwp(energy,id_room,employeeId,i,date);
                        System.out.println("test update conso sur l'équipement = "+i+" dans la room id = "+id_room+" de l'employe id ="+employeeId+" avec energie = "+energy);
                    }
                    else
                        System.out.println("Pas de consommation pour l'équipement = "+i+" dans la room id = "+id_room+" de l'employe id ="+employeeId+" avec energie = "+energy);
                }
                else {
                    // calcul de l'énergie
                    Integer energy = CalculationEnergyConsumed(i, id_room, 0);
                    //insertion en base.
                    if(energy != 0){
                        ConsumptionDwp consumptionDwp = new ConsumptionDwp(null,id_room,employeeId,i,date,energy);
                        consumptionDwpRepo.save(consumptionDwp);
                        System.out.println("test insertion conso sur l'équipement = "+i+" dans la room id = "+id_room+" de l'employe id ="+employeeId+" avec energie = "+energy);
                    }
                    else
                        System.out.println("Pas d'insertion pour l'équipement = "+i+" dans la room id = "+id_room+" de l'employe id ="+employeeId+" avec energie = "+energy);
                }
            }
        }
    }

    public Integer CalculationEnergyConsumed(Integer id_equipment, Integer id_room, Integer energyBeforeCalcul) {
        Integer energy = 0;
        switch (id_equipment) {
            case 1:
                energy = heatingDwpService.CalculatingEnergyConsumed(id_room, energyBeforeCalcul);
                break;
            case 2:
                //LightService.CalculatingEnergyLight
                break;
            case 3:
                //BlindService.CalculatingEnergyBlind
                break;
        }
        return energy;
    }

    @Scheduled(fixedRate = 10000) //add consumption every 10s 
    public void AddConsumption() {
        Iterable<Employee> employeeList = employeeRepo.findAll();
        LocalDateTime newdate = date.plusHours(1);
        setdate(newdate);
        System.out.println(newdate);
       for (Employee employe: employeeList) {
           if(consumptionDwpRepo.checkIfEmployeHaveBooked(employe.getIdEmployee(),newdate) != null)
              ForThisRoomAndEmployee(employe.getIdEmployee(),consumptionDwpRepo.checkIfEmployeHaveBooked(employe.getIdEmployee(),newdate), newdate.toLocalDate());
        }
        System.out.println("-------------------------------------------------------Fin du schedule");
    }


    public List<Map<String,String>> ShowConsumption() {
           return consumptionDwpRepo.getConsumptionDwpByDateAndEnergie();
    }
}

@repository

@Repository
public interface ConsumptionDwpRepo extends JpaRepository<ConsumptionDwp, Integer>  {

    @Query(value ="select id_room from booking where start_time <= ?2 and end_time >= ?2 and id_person=?1", nativeQuery = true)
    List<Integer> checkIfEmployeHaveBooked(int id, LocalDateTime date);

    @Query(value = "select date from consumption_dwp where id_room = ?1 and id_employe = ?2 and id_equipment = ?3", nativeQuery = true)
    LocalDate checkIfDateIsInTable(Integer id_room, Integer id_employe, Integer id_equipment);

    @Transactional
    @Modifying
    @Query(value = "update consumption_dwp set energie=?1 where id_room = ?2 and id_employe = ?3 and id_equipment = ?4 and date=?5", nativeQuery = true)
    void UpdateConsumptionDwp(Integer energy, Integer id_room, Integer id_employe, Integer id_equipment, LocalDate date);

    @Query(value = "select energie from consumption_dwp where id_room = ?1 and id_employe = ?2 and id_equipment = ?3 and date = ?4", nativeQuery = true)
    Integer selectEnergy(Integer id_room, Integer id_employe, Integer id_equipment, LocalDate date);

    //Query test with id=71 brut
    @Query(value = "select date,energie from consumption_dwp where id_employe = 71", nativeQuery = true)
    List<Map<String,String>> getConsumptionDwpByDateAndEnergie();

}
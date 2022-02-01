package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.Employee;
import com.backend.service.backendservice.model.RoomDigital;
import com.backend.service.backendservice.repository.BookingRepo;
import com.backend.service.backendservice.repository.ConsumptionDwpRepo;
import com.backend.service.backendservice.repository.EmployeeRepo;
import com.backend.service.backendservice.repository.RoomDigitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@Service
public class ConsumptionDwpService {

    @Autowired
    ConsumptionDwpRepo consumptionDwpRepo;
    @Autowired
    EmployeeRepo employeeRepo;
 

    LocalDateTime date = LocalDateTime.of(2022,02,01,00,00,00);

    public LocalDateTime getdate() {
        return date;
    }

    public void setdate(LocalDateTime date) {
        this.date = date;
    }

    public void ForThisRoomAndEmployee(Integer employeeId, List<Integer> room_idList){
        Integer [] tab_equipement = {1, 2, 3};
        Random random = new Random();
        Integer id_equipement = tab_equipement[random.nextInt()];
        for (Integer id_room: room_idList) {
            
            //if(consumptionDwpRepo.checkIfDateIsInTable(id_room,employeeId,id_equipement))
        }
    }

// function for choose who equipment to add energy
    public void CalculationEnergyConsumed(Integer id_equipment) {
        switch (id_equipment) {
            case 1:
                //heatingDwpService.CalculatingEnergyHeating
                break;
            case 2:
                //LightService.CalculatingEnergyLight
                break;
            case 3:
                //BlindService.CalculatingEnergyBlind
                break;
            default:
                //
        }
    }

    @Scheduled(fixedRate = 30000)
    public void AddConsumption() {
        Iterable<Employee> employeeList = employeeRepo.findAll();
        LocalDateTime newdate = date.plusHours(1);
        setdate(newdate);
        System.out.println(newdate);
       for (Employee employe: employeeList) {
           if(consumptionDwpRepo.checkIfEmployeHaveBooked(employe.getIdEmployee(),newdate) != null)
              ForThisRoomAndEmployee(employe.getIdEmployee(),consumptionDwpRepo.checkIfEmployeHaveBooked(employe.getIdEmployee(),newdate));
        }
        System.out.println("-------------------------------------------------------Fin du schedule");
    }
}
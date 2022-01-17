package com.backend.service.backendservice.service;


import com.backend.service.backendservice.model.Habitation;
import com.backend.service.backendservice.model.Rooms;
import com.backend.service.backendservice.model.heating;
import com.backend.service.backendservice.repository.HabitationRepo;
import com.backend.service.backendservice.repository.RoomRepo;
import com.backend.service.backendservice.repository.heatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class HabitationService {

    @Autowired
    private HabitationRepo habitationRepo;




    //find home by id
    public Optional<Habitation> getHome(Integer id){return habitationRepo.findById(id);}


    //
    /* public HashMap<Integer,HashMap<String,Iterable<heating>>> HomeInfo(){
       HashMap<Integer,HashMap<String,Iterable<heating>>> homeMapInfo = new HashMap<Integer,HashMap<String,Iterable<heating>>>();
        Iterable<Habitation> homelist = habitationRepo.findAll();
        Iterable<Rooms> roomlist = RoomRepo.findAll();
        Iterable<heating> heatinglist = heatingRepo.findAll();

        for(Habitation habitation : homelist){
            HashMap<String,Iterable<heating>> roomMapInfo = new HashMap<String,Iterable<heating>>();
            for(Rooms room : roomlist){
                if(room.getId_home() == habitation.getId_home()){
                    ArrayList<heating> heatlist = new ArrayList<heating>();
                    for (heating heating : heatinglist){
                        if (heating.getId_room()== room.getId_room()){
                            heatlist.add(heating);
                        }
                    }
                    roomMapInfo.put(room.getRoom_type(), heatlist);
                }

            }
            homeMapInfo.put(habitation.getId_home(), roomMapInfo);
        }

        return homeMapInfo;
        }*/





  /*public  static final String hello (){
   return "je suis l'habitation";
  }*/

  public List<Habitation> getHabitation(){return (List<Habitation>) habitationRepo.findAll();}

    //public String selectAdress(){return habitationRepo.selectAdress();}
}

package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.Rooms;
import com.backend.service.backendservice.model.heating;
import com.backend.service.backendservice.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepo RoomRepo;

    //get all rooms
    public Iterable<Rooms> listRooms(){ return RoomRepo.findAll();}

    //find room by id
    public Optional<Rooms> getRoom(Integer id){return RoomRepo.findById(id);}

    public Iterable<Rooms> listRooms(int id_home)
    {
        Iterable<Rooms> Total_roomlist = RoomRepo.findAll();
        ArrayList<Rooms> Nominal_roomlist=new ArrayList<Rooms>();
        Iterator iter=Total_roomlist.iterator();
        while(iter.hasNext())
        {
            Rooms o= (Rooms) iter.next();
            if(o.getId_home()==id_home){
              Nominal_roomlist.add(o);

            }
        }

        return Nominal_roomlist;
    }
}

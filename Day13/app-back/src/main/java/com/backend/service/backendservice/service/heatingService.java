package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.Rooms;
import com.backend.service.backendservice.model.heating;
import com.backend.service.backendservice.repository.heatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class heatingService {

    @Autowired
    private heatingRepo heatingRepo;

    //get all heatings
    public Iterable<heating> listHeating(){ return heatingRepo.findAll();}

    //find heating by id
    public Optional<heating> getHeating(Integer id){return heatingRepo.findById(id);}

    public Iterable<heating> listheatings(int id_room)
    {
        Iterable<heating> Total_heatinglist = heatingRepo.findAll();
        ArrayList<heating> Nominal_heatinglist=new ArrayList<heating>();
        Iterator iter=Total_heatinglist.iterator();
        while(iter.hasNext())
        {
            heating o= (heating) iter.next();
            if(o.getId_room()==id_room){
                Nominal_heatinglist.add(o);

            }
        }
        return Nominal_heatinglist;
    }
}

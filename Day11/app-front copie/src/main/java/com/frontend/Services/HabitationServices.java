package com.frontend.Services;

import com.frontend.Model.Habitation;
import com.frontend.Model.Rooms;
import com.frontend.Model.heating;
import com.frontend.Repository.HabitationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class HabitationServices {

    @Autowired
    private HabitationProxy proxy;

    public Habitation getHome(int id){return proxy.getHome(id);}
    public Iterable<Habitation> getHomes(){return proxy.getHomes();}

    public HashMap<Integer, HashMap<String,Iterable<heating>>> HomeInfo(){return proxy.HomeInfo();}

    //public  String UserAdress(){return null;}//il faut changer le return et les param

}

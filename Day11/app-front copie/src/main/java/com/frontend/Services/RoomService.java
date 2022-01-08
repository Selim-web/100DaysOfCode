package com.frontend.Services;

import com.frontend.Model.Rooms;
import com.frontend.Repository.RoomProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomProxy proxy;

    public Rooms getRoom(int id){return proxy.getRoom(id);}
    public Iterable<Rooms> listRooms(int id){return proxy.listRooms(id);}
}

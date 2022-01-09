package com.frontend.Services;

import com.frontend.Model.RoomDigital;
import com.frontend.Repository.EquipmentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentProxy proxy;

    public RoomDigital room(Integer room_id) { return proxy.getEquipmentRoom(room_id);}

    public RoomDigital updateRoom(RoomDigital roomDigital) { return proxy.updateRoom(roomDigital);}
}

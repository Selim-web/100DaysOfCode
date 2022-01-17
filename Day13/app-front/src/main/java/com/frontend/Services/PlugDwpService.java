package com.frontend.Services;

import com.frontend.Model.PlugDwp;
import com.frontend.Repository.PlugDwpProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlugDwpService {

    @Autowired
    private PlugDwpProxy proxy;

    public PlugDwp getPlug(Integer room_id) { return proxy.getPlug(room_id);}

    public PlugDwp updatePlug(PlugDwp plugDwp) { return proxy.updatePlug(plugDwp);}

}

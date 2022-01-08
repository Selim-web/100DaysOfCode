package com.frontend.Services;

import com.frontend.Model.LightDwp;
import com.frontend.Repository.LightDwpProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightDwpService {

    @Autowired
    private LightDwpProxy proxy;

    public LightDwp getLight(Integer room_id) { return proxy.getLight(room_id);}

    public LightDwp updateLight(LightDwp lightDwp) {
        return proxy.updateLight(lightDwp);
    }
}

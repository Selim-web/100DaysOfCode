package com.frontend.Services;

import com.frontend.Model.HeatingDwp;
import com.frontend.Repository.HeatingDwpProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeatingDwpService {

    @Autowired
    private HeatingDwpProxy proxy;

    public HeatingDwp getHeating(Integer id) {
        return proxy.getHeating(id);
    }

    public Integer getScenario() { return proxy.getScenario();}

    public HeatingDwp updateHeating(HeatingDwp heatingDwp) { return proxy.updateHeating(heatingDwp); }
}

package com.frontend.Services;

import com.frontend.Model.heating;
import com.frontend.Repository.heatingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class heatingServices {

    @Autowired
    private heatingProxy proxy;

    public heating getHating(int id){return proxy.getHeating(id);}
    public Iterable<heating> getHeatings(int id){return proxy.getHeatings(id);}
}

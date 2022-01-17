package com.frontend.Services;

import com.frontend.Model.ScreenDwp;
import com.frontend.Repository.ScreenDwpProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenDwpService {

    @Autowired
    private ScreenDwpProxy proxy;

    public ScreenDwp getScreen(Integer room_id) { return proxy.getScreen(room_id);}

    public ScreenDwp updateScreen(ScreenDwp screenDwp) { return proxy.updateScreen(screenDwp);}
}

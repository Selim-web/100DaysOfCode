package com.frontend.Services;

import com.frontend.Model.BlindDwp;
import com.frontend.Repository.BlindDwpProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlindDwpService {

    @Autowired
    private BlindDwpProxy proxy;

    public BlindDwp getBlind(Integer room_id) {
        return proxy.getBlind(room_id);
    }

    public BlindDwp updateBlind(BlindDwp blindDwp) {
        return proxy.updateBlind(blindDwp);
    }
}

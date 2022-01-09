package com.frontend.Services;

import java.util.List;
import java.util.Map;
import com.frontend.Model.Message;
import com.frontend.Repository.MessageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServices {

    @Autowired
    private MessageProxy proxy;

    public List<Message> getMessages(Integer id_sender, Integer id_receiver) {
        return proxy.getMessages(id_sender, id_receiver);
    }

    public List<Map<String, String>> getContacts(Integer id_sender, Integer idCompany) {
        return proxy.getContacts(id_sender, idCompany);
    }
}

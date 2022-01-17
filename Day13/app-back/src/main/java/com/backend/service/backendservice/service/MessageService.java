package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.Message;
import com.backend.service.backendservice.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<Message> getMessages(Integer id_sender, Integer id_receiver) {
        return (List<Message>) messageRepo.findAllMessagesBetweenTwoPeople(id_sender, id_receiver);
    }

    public Message saveMessage(Message msg) {
        Message messageSaved = messageRepo.save(msg);
        return messageSaved;
    }

    public Integer lastId() {
        Integer lastId = messageRepo.lastId();
        return lastId;
    }

    public List<Map<String, String>> getContactOfOneUser(Integer id_sender, Integer idCompany) {
        return messageRepo.findAllContactOfOneUser(id_sender, idCompany);
    }
}

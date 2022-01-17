package com.backend.service.backendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import com.backend.service.backendservice.model.Message;
import com.backend.service.backendservice.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * Select - select messages between two users
     *
     * @param id_sender,   person who send messages
     * @param id_receiver, person who receive messages
     * @return list of message
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping("/getMessages")
    public List<Message> getMessages(@RequestParam("id_sender") Integer id_sender,
            @RequestParam("id_receiver") Integer id_receiver) {
        return messageService.getMessages(id_sender, id_receiver);
    }

    /**
     * Select - select contacts
     *
     * @param id_sender,  person who send messages , person who represents session
     * @param id_company, person's company
     * @return list of contacts
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping("/getContacts")
    public List<Map<String, String>> getContacts(@RequestParam("id_sender") Integer idSender,
            @RequestParam("id_company") Integer idCompany) {
        List<Map<String, String>> listUsers = messageService.getContactOfOneUser(idSender, idCompany);
        return listUsers;
    }

    /**
     * Create - Create messages
     *
     * @param m entity message
     * @return list of contacts
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @PostMapping("/createMessage")
    public Message savedMessage(@RequestBody Message m) {
        Integer lastId = messageService.lastId();
        m.setIdMessage(lastId + 1);
        Message messageSaved = messageService.saveMessage(m);
        return messageSaved;
    }
}

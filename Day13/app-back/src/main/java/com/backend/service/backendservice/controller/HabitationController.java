package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.Habitation;
import com.backend.service.backendservice.model.Rooms;
import com.backend.service.backendservice.model.heating;
import com.backend.service.backendservice.service.HabitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Home")
public class HabitationController {


    @Autowired
    private HabitationService habitationService;

    @GetMapping("/listHomes")
    public Iterable<Habitation> getEachHome() {return habitationService.getHabitation();}

    @GetMapping("/getHome")
    public Habitation homeById(@RequestParam("id") final Integer id) {
        Optional<Habitation> h = habitationService.getHome(id);
            return h.get();

    }


  //@GetMapping("/habitation")
  //public String get(){
   //return habitationService.hello();
 // }

  @GetMapping("/list")
  public List<Habitation> list(){return habitationService.getHabitation();}

   // @GetMapping(value = "/selectAdress")
    //public String selectAdress(@RequestParam("adress")){return habitationService.selectAdress();}
}



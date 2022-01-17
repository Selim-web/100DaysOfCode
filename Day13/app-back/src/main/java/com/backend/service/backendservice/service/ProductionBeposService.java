package com.backend.service.backendservice.service;

import java.util.List;
import java.util.Optional;
import com.backend.service.backendservice.repository.ProductionBeposRepo;
import com.backend.service.backendservice.model.Habitation;
import com.backend.service.backendservice.model.Power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionBeposService {

 @Autowired
 private ProductionBeposRepo repo;


 public String listUserService(int id){
  return repo.userRepo(id);
}

// public Optional<Habitation> getHome(Integer id){
//   return repo.findById(id);
// }

// public List<Habitation> getHabitation(){
//   return (List<Habitation>) repo.findAll();
// }

public List<String> listRoomsService(int id){
  return repo.listRepoRooms(id);
}

public List<String> listRoomsServic(){
  return repo.listRepoRoom();
}

public List<String> listAdressService(){
  return repo.listAdressRepo();
}

public List<String> listPowerService(){
  return repo.ConsumPowerRepo();
}

public Iterable<Power> findlistPower(){
  return repo.findAll();
}

public Integer sumService(){
  return repo.sumPower();
}

}

package com.frontend.Services;

import java.util.List;
import java.util.Optional;

import com.frontend.Model.Power;
import com.frontend.Repository.ProductionBeposProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionBeposService {

 @Autowired
 private ProductionBeposProxy proxy;


 public List<String> getTypeHabitation(int id){
		return proxy.typeHabitation(id);
 }

	public String getmessage(){
		return proxy.messageBack();
 }

	public List<String> listRoomService(){
		return proxy.listRoom();
	}

	public List<String> listAdresseService(){
		return proxy.addressProxy();
	}

	public  Iterable<Power> listPower(){
		return proxy.powerMachine();
	}

	public int sumPowerService(){
		return proxy.sumPower();
	}

}

package com.backend.service.backendservice.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.backendservice.model.Eco_district;
import com.backend.service.backendservice.model.Entity_map;
import com.backend.service.backendservice.repository.RankingRepo;
import com.backend.service.backendservice.repository.EntityRepo;

@Service
public class RankingService {
	@Autowired
    private RankingRepo rankRepo;
	public ArrayList<String> energyByRank()
	{
		return rankRepo.energyByRank();
	}
}

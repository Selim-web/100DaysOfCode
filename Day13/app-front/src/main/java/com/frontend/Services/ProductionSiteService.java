package com.frontend.Services;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontend.Model.ProductionSite;
import com.frontend.Repository.ProductionSiteProxy;

@Service
public class ProductionSiteService {
	@Autowired
	private ProductionSiteProxy proxy;

}

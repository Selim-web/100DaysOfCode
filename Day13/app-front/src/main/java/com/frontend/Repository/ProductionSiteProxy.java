package com.frontend.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.frontend.CustomProperties;
import com.frontend.Model.ProductionSite;

import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductionSiteProxy {
	@Autowired
	private CustomProperties props;
	
	
}

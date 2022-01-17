package com.frontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.frontend.Services.ProductionSiteService;

@Controller
public class ProductionSiteController {
	@Autowired
	private ProductionSiteService services;
}

package com.frontend.Controller;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frontend.Model.Company;
import com.frontend.Services.CompanyServices;

@Controller
public class CompanyController {

	@Autowired
	private CompanyServices services;

	@GetMapping("/homePage")
	public String homePage() {
		return "homePage";

	}

	@GetMapping("/createCompany")
	public String createCompany(Model model) {
		Company comp = new Company();
		model.addAttribute("company", comp);
		model.addAttribute("operationName", "create");
		return "createCompany";

	}

	@GetMapping("/updateCompany")
	public String updateCompany(Model model, @RequestParam(name = "operationName") String operation) {
		ArrayList<Company> listCompany = (ArrayList<Company>) services.getCompanies();
		Collections.sort(listCompany);
		model.addAttribute("companies", listCompany);
		model.addAttribute("company", listCompany.get(0));
		model.addAttribute("operation", operation);
		return "updateCompany";

	}

	@PostMapping("/crudCompany")
	public ModelAndView crudCompany(@RequestParam(name = "operationName") String operation,
			@ModelAttribute Company company) {
		System.out.print("operation name==> " + operation);
		if (operation.equals("update")) {
			services.saveCompany(company);
			return new ModelAndView("redirect:/getCompany?id=" + company.getId());
		} else if (operation.equals("delete")) {
			services.deleteCompany(company.getId());
			return new ModelAndView("redirect:/");
		} else {
			company.setId(services.getLatestId() + 1);
			services.saveCompany(company);
			return new ModelAndView("redirect:/getCompany?id=" + company.getId());
		}
	}

	@GetMapping("/searchCompany")
	public String oneCompany(Model model, HttpSession session) {
		model.addAttribute("id", session.getAttribute("id"));
		return "findCompany";
	}

	@GetMapping("/getCompany")
	public String getCompany(@RequestParam(name = "id") int id, Model model) {
		Company company = services.getCompany(id);
		model.addAttribute("company", company);
		return "theCompany";

	}

	@GetMapping("/companyName")
	public String oneCompanyByName(@RequestParam(name = "name") String name, Model model) {
		Company company = services.getCompanyByName(name);
		if (company != null) {
			model.addAttribute("company", company);
			return "theCompany";
		} else
			return "homePage";

	}

	@GetMapping("/listCompany")
	public String listCompany(Model model) {
		ArrayList<Company> listCompany = (ArrayList<Company>) services.getCompanies();
		Collections.sort(listCompany);
		model.addAttribute("companies", listCompany);
		return "ListCompany";
	}

	@GetMapping("/myMap")
	public String mapPage()
	{
		return "map";
		
	}

}

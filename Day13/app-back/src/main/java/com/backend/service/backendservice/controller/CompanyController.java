package com.backend.service.backendservice.controller;

import com.backend.service.backendservice.model.Company;
import com.backend.service.backendservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    /**
    * Create - Add a new company
    *
    * @param company An object company
    * @return The company object saved
    */
    @PostMapping("/createCompany")
    public Company savedCompany(@RequestBody Company c) {
        Company companySaved = service.saveCompany(c);
        return companySaved;
    }

    /**
    * Read - Search all companies
    *
    * @return all companies
    */
    @GetMapping("/listCompany")
    public Iterable<Company> listCompany() {
        Iterable<Company> listComp = service.listCompany();
        return listComp;
    }

    /**
    * Read - Search all companies
    *
    * @param name A name of a company
    * @return all companies
    */
    @GetMapping("/companyName")
    public Company CompanyByName(@RequestParam(name = "name") final String name) {
        Company c = service.findCompanyByName(name);
        return c;
    }

    /**
    * Update - Update a company
    *
    * @param id    An id of one company
    * @param value A value
    * @param field A field to change
    * @return The company object saved
    */
    @GetMapping("/updateCompany")
    public Company updateCompany(@RequestParam(name = "id") Integer id) {
        Optional<Company> c = service.getCompany(id);
        if (c.isPresent()) {
            Company company = c.get();
            service.saveCompany(company);
            return c.get();
        } else
            return null;
    }

    /**
    * Read - Search a company
    *
    * @param id An id of one company
    * @return The company
    */
    @GetMapping("/getCompany")
    public Company printCompany(@RequestParam("id") final Integer id) {
        Optional<Company> c = service.getCompany(id);
        if (c.isPresent()) {
            return c.get();
        } else
            return null;
    }

    /**
    * Delete - Delete a company
    *
    * @param id - The id of the company to delete
    */
    @DeleteMapping("/deleteCompany")
    public void deleteCompany(@RequestParam("id") final Integer id) {
        service.deleteCompany(id);
    }


    /**
    * Read - Search companies with the good nbBuilding
    *
    * @param nbr Nbr is nbBuilding of one company
    * @return A list of company
    */
    @GetMapping("/numberBuildingCompany")
    public List<Company> nbBuildingCompany(@RequestParam("nbr") final Integer nbr) {
        List<Company> listComp = (List<Company>) service.nbBuildingCompany(nbr);
        return listComp;
    }

    /**
    * Read - Search companies with the good location
    *
    * @param location Location is the location of companies
    * @return A list of company
    */
    @GetMapping("/locationCompany")
    public List<Company> locationCompany(@RequestParam("location") final String location) {
        List<Company> listComp = (List<Company>) service.locationCompany(location);
        return listComp;
    }

    /**
    * Read - Search companies with the good location
    *
    * @param location Location is the location of companies
    * @return A list of company
    */
    @GetMapping("/locationCompanyV2")
    public List<Company> locationCompanyV2(@RequestParam("location") final String location) {
        List<Company> listComp = (List<Company>) service.locationCompanyV2(location);
        return listComp;
    }

    /**
    * Read - Number of company with the same location
    *
    * @param location Location is the location of companies
    * @return number
    */
    @GetMapping("/nbCompanyInSameLocation")
    public Integer findCountByLocation(@RequestParam("location") final String location) {
        Integer nbCompanyInSameLocation = service.findCountByLocation(location);
        return nbCompanyInSameLocation;
    }
    

}

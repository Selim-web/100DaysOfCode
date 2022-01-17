package com.backend.service.backendservice.service;

import com.backend.service.backendservice.model.Company;
import com.backend.service.backendservice.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    // create or update Company
    public Company saveCompany(Company company) {
        Company companySaved = companyRepo.save(company);
        return companySaved;
    }

    // delete company using id
    public void deleteCompany(int id){
        companyRepo.deleteById(id);
    }

    public Optional<Company> getCompany(Integer id) {
        return companyRepo.findById(id);
    }

    public Company findCompanyByName(String name) {
        Iterable<Company> companyList=companyRepo.findAll();
        Company company=null;
        for(Company c : companyList){
            if(c.getName().equals(name)){
                company=c;
                break;
            }
        }
	    return company;
    }
    
    // get the companies list
    public Iterable<Company> listCompany(){
        return companyRepo.findAll();
    }

    public List<Company> nbBuildingCompany(Integer nbr){
        return (List<Company>) companyRepo.nbBuildingCompany(nbr);
    }
    public List<Company> locationCompany(String location){
        return (List<Company>) companyRepo.findByLocation(location);
    }

    public List<Company> locationCompanyV2(String location){
        return (List<Company>) companyRepo.findByLocationV2(location);
    }

    public Integer findCountByLocation(String location){
        return companyRepo.findCountByLocation(location);
    }
    
    public Integer getLatestId(){
        return  companyRepo.findLatestId();
    }
}

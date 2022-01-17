package com.backend.service.backendservice;

import com.backend.service.backendservice.controller.CompanyController;
import com.backend.service.backendservice.model.Company;
import com.backend.service.backendservice.repository.CompanyRepo;
import com.backend.service.backendservice.service.CompanyService;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CompanyServiceTest {

    @Mock
    private CompanyRepo repo;
    private AutoCloseable closeable;

    @InjectMocks
    private CompanyService service;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void listCompanies() {
        Iterable<Company> companies = repo.findAll();

        Iterable<Company> companiesTest = service.listCompany();

        Assert.assertEquals(companies, companiesTest);
    }

    @Test
    public void saveCompany() {
        Company c1 = new Company();
        c1.setId(10);
        c1.setLocation("paris");
        c1.setName("test");
        c1.setnbbuilding(10);

        when(repo.save(any(Company.class))).thenReturn(c1);
        Company savedCompany = repo.save(c1);
        Assert.assertEquals("test", savedCompany.getName());
    }
}

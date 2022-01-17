package com.backend.service.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_employee")
    private Integer idEmployee;
    private Boolean sg;
    private String status;
    @Column(name = "id_company")
    private Integer idCompany;
    @Column(name = "id_role")
    private Integer idRole;

    public Employee() {

    }

    public Employee(Integer id, Boolean sg, String status, Integer idCompany) {
        this.idEmployee = id;
        this.sg = sg;
        this.status = status;
        this.idCompany = idCompany;
    }

    @Id
    public Integer getIdEmployee() {
        return this.idEmployee;
    }

    /**
     * @param id the id to set
     */
    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    /**
     * @return Boolean return the sg
     */
    public Boolean isSg() {
        return this.sg;
    }

    /**
     * @param sg the sg to set
     */
    public void setSg(Boolean sg) {
        this.sg = sg;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Integer return the idCompany
     */
    public Integer getIdCompany() {
        return this.idCompany;
    }

    /**
     * @param idCompany the idCompany to set
     */
    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    /**
     * @return Integer return the idRole
     */
    public Integer getIdRole() {
        return idRole;
    }

    /**
     * @param idRole the idRole to set
     */
    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

}

package com.frontend.Model;

public class Employee {
    private Integer idEmployee;
    private Boolean sg;
    private String status;
    private Integer idCompany;
    private Integer idRole;

    public Employee() {
    }

    public Employee(Integer id, Boolean sg, String status, Integer idCompany, Integer idRole) {
        this.idEmployee = id;
        this.sg = sg;
        this.status = status;
        this.idCompany = idCompany;
        this.idRole = idRole;
    }

    /**
     * @return Integer return the idEmployee
     */
    public Integer getIdEmployee() {
        return idEmployee;
    }

    /**
     * @param idEmployee the idEmployee to set
     */
    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    /**
     * @return Boolean return the sg
     */
    public Boolean isSg() {
        return sg;
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
        return status;
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
        return idCompany;
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

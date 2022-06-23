package model.MRAForm.Cost;

import com.opencsv.bean.CsvBindByName;

public class SalaryDetail {
    @CsvBindByName
    String name;
    @CsvBindByName
    String designation;
    @CsvBindByName
    String nricPassportNo;
    @CsvBindByName
    String nationalityType;
    @CsvBindByName
    String roleInProject;
    @CsvBindByName
    String numberOfMonths;
    @CsvBindByName
    String monthlySalaryCurrency;
    @CsvBindByName
    String monthlySalaryAmount;
    @CsvBindByName
    String actualMonthlySalaryAmount;
    @CsvBindByName
    String actualEstimatedCost;
    @CsvBindByName
    String supportingDocumentLocation;
    @CsvBindByName
    String remarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNricPassportNo() {
        return nricPassportNo;
    }

    public void setNricPassportNo(String nricPassportNo) {
        this.nricPassportNo = nricPassportNo;
    }

    public String getNationalityType() {
        return nationalityType;
    }

    public void setNationalityType(String nationalityType) {
        this.nationalityType = nationalityType;
    }

    public String getRoleInProject() {
        return roleInProject;
    }

    public void setRoleInProject(String roleInProject) {
        this.roleInProject = roleInProject;
    }

    public String getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(String numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public String getMonthlySalaryCurrency() {
        return monthlySalaryCurrency;
    }

    public void setMonthlySalaryCurrency(String monthlySalaryCurrency) {
        this.monthlySalaryCurrency = monthlySalaryCurrency;
    }

    public String getMonthlySalaryAmount() {
        return monthlySalaryAmount;
    }

    public void setMonthlySalaryAmount(String monthlySalaryAmount) {
        this.monthlySalaryAmount = monthlySalaryAmount;
    }

    public String getActualMonthlySalaryAmount() {
        return actualMonthlySalaryAmount;
    }

    public void setActualMonthlySalaryAmount(String actualMonthlySalaryAmount) {
        this.actualMonthlySalaryAmount = actualMonthlySalaryAmount;
    }

    public String getActualEstimatedCost() {
        return actualEstimatedCost;
    }

    public void setActualEstimatedCost(String actualEstimatedCost) {
        this.actualEstimatedCost = actualEstimatedCost;
    }

    public String getSupportingDocumentLocation() {
        return supportingDocumentLocation;
    }

    public void setSupportingDocumentLocation(String supportingDocumentLocation) {
        this.supportingDocumentLocation = supportingDocumentLocation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public SalaryDetail() {
    }

    public SalaryDetail(String name, String designation, String nricPassportNo, String nationalityType, String roleInProject, String numberOfMonths, String monthlySalaryCurrency, String monthlySalaryAmount, String actualMonthlySalaryAmount, String actualEstimatedCost, String supportingDocumentLocation, String remarks) {
        this.name = name;
        this.designation = designation;
        this.nricPassportNo = nricPassportNo;
        this.nationalityType = nationalityType;
        this.roleInProject = roleInProject;
        this.numberOfMonths = numberOfMonths;
        this.monthlySalaryCurrency = monthlySalaryCurrency;
        this.monthlySalaryAmount = monthlySalaryAmount;
        this.actualMonthlySalaryAmount = actualMonthlySalaryAmount;
        this.actualEstimatedCost = actualEstimatedCost;
        this.supportingDocumentLocation = supportingDocumentLocation;
        this.remarks = remarks;
    }
}

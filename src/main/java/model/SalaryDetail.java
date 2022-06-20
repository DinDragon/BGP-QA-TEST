package model;

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
    String monthlySalartCurrency;
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
}

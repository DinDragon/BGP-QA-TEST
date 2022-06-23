package model.MRAForm.Cost;

import com.opencsv.bean.CsvBindByName;

public class OfficeSpaceRentalDetail {
    @CsvBindByName
    String description;
    @CsvBindByName
    String rentalDuration;
    @CsvBindByName
    String monthyRentalCurrency;
    @CsvBindByName
    String montlyRentalAmount;
    @CsvBindByName
    String estimatedCost;
    @CsvBindByName
    String actualMonthlyRental;
    @CsvBindByName
    String actualEstimatedCost;
    @CsvBindByName
    String supportingDocumentLocation;
    @CsvBindByName
    String remarks;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(String rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public String getMonthyRentalCurrency() {
        return monthyRentalCurrency;
    }

    public void setMonthyRentalCurrency(String monthyRentalCurrency) {
        this.monthyRentalCurrency = monthyRentalCurrency;
    }

    public String getMontlyRentalAmount() {
        return montlyRentalAmount;
    }

    public void setMontlyRentalAmount(String montlyRentalAmount) {
        this.montlyRentalAmount = montlyRentalAmount;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getActualMonthlyRental() {
        return actualMonthlyRental;
    }

    public void setActualMonthlyRental(String actualMonthlyRental) {
        this.actualMonthlyRental = actualMonthlyRental;
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

    public OfficeSpaceRentalDetail() {
    }

    public OfficeSpaceRentalDetail(String description, String rentalDuration, String monthyRentalCurrency, String montlyRentalAmount, String estimatedCost, String actualMonthlyRental, String actualEstimatedCost, String supportingDocumentLocation, String remarks) {
        this.description = description;
        this.rentalDuration = rentalDuration;
        this.monthyRentalCurrency = monthyRentalCurrency;
        this.montlyRentalAmount = montlyRentalAmount;
        this.estimatedCost = estimatedCost;
        this.actualMonthlyRental = actualMonthlyRental;
        this.actualEstimatedCost = actualEstimatedCost;
        this.supportingDocumentLocation = supportingDocumentLocation;
        this.remarks = remarks;
    }
}

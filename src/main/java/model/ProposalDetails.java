package model;

import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;

public class ProposalDetails {
    @CsvBindByName
    String projectTitle;
    @CsvBindByName
    LocalDate startDate;
    @CsvBindByName
    LocalDate endDate;
    @CsvBindByName
    String projectDescription;
    @CsvBindByName
    String activity;
    @CsvBindByName
    String targetMarket;
    @CsvBindByName
    String firstTimeApplication;
    @CsvBindByName
    String supportingDocumentLocation;
    @CsvBindByName
    String remarks;

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTargetMarket() {
        return targetMarket;
    }

    public void setTargetMarket(String targetMarket) {
        this.targetMarket = targetMarket;
    }

    public String getFirstTimeApplication() {
        return firstTimeApplication;
    }

    public void setFirstTimeApplication(String firstTimeApplication) {
        this.firstTimeApplication = firstTimeApplication;
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

    public ProposalDetails(String projectTitle, LocalDate startDate, LocalDate endDate, String projectDescription, String activity, String targetMarket, String firstTimeApplication, String supportingDocumentLocation, String remarks) {
        this.projectTitle = projectTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDescription = projectDescription;
        this.activity = activity;
        this.targetMarket = targetMarket;
        this.firstTimeApplication = firstTimeApplication;
        this.supportingDocumentLocation = supportingDocumentLocation;
        this.remarks = remarks;
    }

    public ProposalDetails() {
    }
}

package model;

import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;

public class BusinessImpactDetails {
    @CsvBindByName
    LocalDate FYEndDate;
    @CsvBindByName
    String overseasSale1;
    @CsvBindByName
    String overseasSale2;
    @CsvBindByName
    String overseasSale3;
    @CsvBindByName
    String overseasSale4;
    @CsvBindByName
    String overseasInvestments1;
    @CsvBindByName
    String overseasInvestments2;
    @CsvBindByName
    String overseasInvestment3;
    @CsvBindByName
    String overseasInvestments4;
    @CsvBindByName
    String rationaleForProjections;
    @CsvBindByName
    String nonTangibleBenefits;


    public LocalDate getFYEndDate() {
        return FYEndDate;
    }

    public void setFYEndDate(LocalDate FYEndDate) {
        this.FYEndDate = FYEndDate;
    }

    public String getOverseasSale1() {
        return overseasSale1;
    }

    public void setOverseasSale1(String overseasSale1) {
        this.overseasSale1 = overseasSale1;
    }

    public String getOverseasSale2() {
        return overseasSale2;
    }

    public void setOverseasSale2(String overseasSale2) {
        this.overseasSale2 = overseasSale2;
    }

    public String getOverseasSale3() {
        return overseasSale3;
    }

    public void setOverseasSale3(String overseasSale3) {
        this.overseasSale3 = overseasSale3;
    }

    public String getOverseasSale4() {
        return overseasSale4;
    }

    public void setOverseasSale4(String overseasSale4) {
        this.overseasSale4 = overseasSale4;
    }

    public String getOverseasInvestments1() {
        return overseasInvestments1;
    }

    public void setOverseasInvestments1(String overseasInvestments1) {
        this.overseasInvestments1 = overseasInvestments1;
    }

    public String getOverseasInvestments2() {
        return overseasInvestments2;
    }

    public void setOverseasInvestments2(String overseasInvestments2) {
        this.overseasInvestments2 = overseasInvestments2;
    }

    public String getOverseasInvestment3() {
        return overseasInvestment3;
    }

    public void setOverseasInvestment3(String overseasInvestment3) {
        this.overseasInvestment3 = overseasInvestment3;
    }

    public String getOverseasInvestments4() {
        return overseasInvestments4;
    }

    public void setOverseasInvestments4(String overseasInvestments4) {
        this.overseasInvestments4 = overseasInvestments4;
    }

    public String getRationaleForProjections() {
        return rationaleForProjections;
    }

    public void setRationaleForProjections(String rationaleForProjections) {
        this.rationaleForProjections = rationaleForProjections;
    }

    public String getNonTangibleBenefits() {
        return nonTangibleBenefits;
    }

    public void setNonTangibleBenefits(String nonTangibleBenefits) {
        this.nonTangibleBenefits = nonTangibleBenefits;
    }

    public BusinessImpactDetails(LocalDate FYEndDate, String overseasSale1, String overseasSale2, String overseasSale3, String overseasSale4, String overseasInvestments1, String overseasInvestments2, String overseasInvestment3, String overseasInvestments4, String rationaleForProjections, String nonTangibleBenefits) {
        this.FYEndDate = FYEndDate;
        this.overseasSale1 = overseasSale1;
        this.overseasSale2 = overseasSale2;
        this.overseasSale3 = overseasSale3;
        this.overseasSale4 = overseasSale4;
        this.overseasInvestments1 = overseasInvestments1;
        this.overseasInvestments2 = overseasInvestments2;
        this.overseasInvestment3 = overseasInvestment3;
        this.overseasInvestments4 = overseasInvestments4;
        this.rationaleForProjections = rationaleForProjections;
        this.nonTangibleBenefits = nonTangibleBenefits;
    }

    public BusinessImpactDetails() {
    }
}

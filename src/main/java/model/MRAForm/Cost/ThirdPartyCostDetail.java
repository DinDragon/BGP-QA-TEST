package model.MRAForm.Cost;

import com.opencsv.bean.CsvBindByName;

public class ThirdPartyCostDetail {
    @CsvBindByName
    String isVendorSg;
    @CsvBindByName
    String vendorName;
    @CsvBindByName
    String uen;
    @CsvBindByName
    String supportingDocumentLocation;
    @CsvBindByName
    String estimatedCostCurrency;
    @CsvBindByName
    String estimatedCostAmount;
    @CsvBindByName
    String remarks;
    @CsvBindByName
    String exchangeRate;
    @CsvBindByName
    String isVendorNameInvalid;
    public String getIsVendorSg() {
        return isVendorSg;
    }

    public void setIsVendorSg(String isVendorSg) {
        this.isVendorSg = isVendorSg;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getUen() {
        return uen;
    }

    public void setUen(String uen) {
        this.uen = uen;
    }

    public String getSupportingDocumentLocation() {
        return supportingDocumentLocation;
    }

    public void setSupportingDocumentLocation(String supportingDocumentLocation) {
        this.supportingDocumentLocation = supportingDocumentLocation;
    }

    public String getEstimatedCostCurrency() {
        return estimatedCostCurrency;
    }

    public void setEstimatedCostCurrency(String estimatedCostCurrency) {
        this.estimatedCostCurrency = estimatedCostCurrency;
    }

    public String getEstimatedCostAmount() {
        return estimatedCostAmount;
    }

    public void setEstimatedCostAmount(String estimatedCostAmount) {
        this.estimatedCostAmount = estimatedCostAmount;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIsVendorNameInvalid() {
        return isVendorNameInvalid;
    }

    public void setIsVendorNameInvalid(String isVendorNameInvalid) {
        this.isVendorNameInvalid = isVendorNameInvalid;
    }

    public ThirdPartyCostDetail(String isVendorSg, String vendorName, String uen, String supportingDocumentLocation, String estimatedCostCurrency, String estimatedCostAmount, String remarks, String exchangeRate) {
        this.isVendorSg = isVendorSg;
        this.vendorName = vendorName;
        this.uen = uen;
        this.supportingDocumentLocation = supportingDocumentLocation;
        this.estimatedCostCurrency = estimatedCostCurrency;
        this.estimatedCostAmount = estimatedCostAmount;
        this.remarks = remarks;
        this.exchangeRate = exchangeRate;
    }

    public ThirdPartyCostDetail() {
    }
}

package model.MRAForm;

import com.opencsv.bean.CsvBindByName;

public class ContactDetail {
    @CsvBindByName
    String name;
    @CsvBindByName
    String jobTitle;
    @CsvBindByName
    String contactNumber;
    @CsvBindByName
    String emailAddress;
    @CsvBindByName
    String altEmailAddress;
    @CsvBindByName
    String isMailAddrSame;
    @CsvBindByName
    String postalCode;
    @CsvBindByName
    String blkHouseNo;
    @CsvBindByName
    String street;
    @CsvBindByName
    String level;
    @CsvBindByName
    String unit;
    @CsvBindByName
    String buildingName;
    @CsvBindByName
    String isLOASame;
    @CsvBindByName
    String LOAName;
    @CsvBindByName
    String LOAJobTitle;
    @CsvBindByName
    String LOAEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAltEmailAddress() {
        return altEmailAddress;
    }

    public void setAltEmailAddress(String altEmailAddress) {
        this.altEmailAddress = altEmailAddress;
    }

    public String getIsMailAddrSame() {
        return isMailAddrSame;
    }

    public void setIsMailAddrSame(String isMailAddrSame) {
        this.isMailAddrSame = isMailAddrSame;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBlkHouseNo() {
        return blkHouseNo;
    }

    public void setBlkHouseNo(String blkHouseNo) {
        this.blkHouseNo = blkHouseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getIsLOASame() {
        return isLOASame;
    }

    public void setIsLOASame(String isLOASame) {
        this.isLOASame = isLOASame;
    }

    public String getLOAName() {
        return LOAName;
    }

    public void setLOAName(String LOAName) {
        this.LOAName = LOAName;
    }

    public String getLOAJobTitle() {
        return LOAJobTitle;
    }

    public void setLOAJobTitle(String LOAJobTitle) {
        this.LOAJobTitle = LOAJobTitle;
    }

    public String getLOAEmail() {
        return LOAEmail;
    }

    public void setLOAEmail(String LOAEmail) {
        this.LOAEmail = LOAEmail;
    }

    public ContactDetail(String name, String jobTitle, String contactNumber, String emailAddress, String altEmailAddress, String isMailAddrSame, String postalCode, String blkHouseNo, String street, String level, String unit, String buildingName, String isLOASame, String LOAName, String LOAJobTitle, String LOAEmail) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.altEmailAddress = altEmailAddress;
        this.isMailAddrSame = isMailAddrSame;
        this.postalCode = postalCode;
        this.blkHouseNo = blkHouseNo;
        this.street = street;
        this.level = level;
        this.unit = unit;
        this.buildingName = buildingName;
        this.isLOASame = isLOASame;
        this.LOAName = LOAName;
        this.LOAJobTitle = LOAJobTitle;
        this.LOAEmail = LOAEmail;
    }

    public ContactDetail() {
    }
}

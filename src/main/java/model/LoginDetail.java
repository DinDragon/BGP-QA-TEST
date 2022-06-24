package model;
import com.opencsv.*;
import com.opencsv.bean.CsvBindByName;

public class LoginDetail {

    @CsvBindByName(column = "userUEN")
    public String userUEN;
    @CsvBindByName(column = "userId")
    public String userId;
    @CsvBindByName(column = "userRole")
    public String userRole;
    @CsvBindByName(column = "userName")
    public String userName;

    @CsvBindByName(column = "postalCode")
    public String postalCode;

    @CsvBindByName(column = "blkHseNo")
    public String blkHseNo;

    @CsvBindByName(column = "street")
    public String street;
    @CsvBindByName(column = "level")
    public String level;
    @CsvBindByName(column = "unit")
    public String unit;
    @CsvBindByName(column = "buildingName")
    public String buildingName;


    public String getUserUEN() {
        return userUEN;
    }

    public void setUserUEN(String userUEN) {
        this.userUEN = userUEN;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBlkHseNo() {
        return blkHseNo;
    }

    public void setBlkHseNo(String blkHseNo) {
        this.blkHseNo = blkHseNo;
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

    public LoginDetail() {
    }

    public LoginDetail(String userUEN, String userId, String userRole, String userName, String postalCode, String blkHseNo, String street, String level, String unit, String buildingName) {
        this.userUEN = userUEN;
        this.userId = userId;
        this.userRole = userRole;
        this.userName = userName;
        this.postalCode = postalCode;
        this.blkHseNo = blkHseNo;
        this.street = street;
        this.level = level;
        this.unit = unit;
        this.buildingName = buildingName;
    }
}

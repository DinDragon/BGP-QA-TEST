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

    public LoginDetail() {
    }

    public LoginDetail(String userUEN, String userId, String userRole, String userName) {
        this.userUEN = userUEN;
        this.userId = userId;
        this.userRole = userRole;
        this.userName = userName;
    }
}

package modules;

// Generated by Selenium IDE
import constants.Constants;
import model.LoginDetail;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class ManualLogin {

  public static void serverLogin(WebDriver driver) throws IOException {
    String baseURL = PropertyReader.getProperty(Constants.PROPERTY_VARIABLE.BASE_URL);

    driver.get(baseURL);
    driver.manage().window().maximize();
    //driver.manage().window().setSize(new Dimension(1920, 1080));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".modal-dialog")).click();
    WebElement usernameBox = driver.findElement(By.cssSelector("div:nth-child(2) > div > div > .cognito-asf #signInFormUsername"));
    usernameBox.click();

    usernameBox.sendKeys(PropertyReader.getProperty(Constants.PROPERTY_VARIABLE.SERVER_LOGIN_USERNAME));
    WebElement pswdBox = driver.findElement(By.cssSelector("div:nth-child(2) > div > div > .cognito-asf #signInFormPassword"));
    pswdBox.click();
    pswdBox.sendKeys(PropertyReader.getProperty(Constants.PROPERTY_VARIABLE.SERVER_LOGIN_PASSWORD));

//    synchronized (driver) {
//
//      driver.wait();
//    }
    driver.findElement(By.cssSelector("div:nth-child(2) > div > div > .cognito-asf > .btn")).click();
  }
  public static void logIn(WebDriver driver, LoginDetail loginDetail) throws InterruptedException, IOException {
    String baseURL = PropertyReader.getProperty(Constants.PROPERTY_VARIABLE.BASE_URL);

    driver.get(baseURL);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".landing-box-login-header-9F3Tb")));
    }
    driver.findElement(By.cssSelector(".landing-box-login-header-9F3Tb")).click();

    driver.findElement(By.id("entityId")).click();
    driver.findElement(By.id("entityId")).sendKeys(loginDetail.getUserUEN());
    driver.findElement(By.id("userId")).click();
    driver.findElement(By.id("userId")).sendKeys(loginDetail.getUserId());
    driver.findElement(By.id("userRole")).click();
    driver.findElement(By.id("userRole")).sendKeys(loginDetail.getUserRole());
    driver.findElement(By.id("userFullName")).click();
    driver.findElement(By.id("userFullName")).sendKeys(loginDetail.getUserName());
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector("#user-info-item .username")).click();
    assertThat(driver.findElement(By.cssSelector("#user-info-item .username")).getText(), is(loginDetail.getUserName()));
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dashboard-menubox-app-apply-grant .dashboard-action-title")));
    }


  }
}

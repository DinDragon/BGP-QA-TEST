package testCases;

import DataReader.LoginDataReader;
import model.LoginDetail;
import modules.LoadMRAForm;
import modules.ManualLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.PropertyReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Test1 {

    public static WebDriver driver;
    private Map<String, Object> vars;

    static LoginDataReader loginDataReader = new LoginDataReader();

    JavascriptExecutor js;

    @Before
    public void setUp() throws IOException {
        ChromeOptions options = new ChromeOptions();
        PropertyReader propertyReader = new PropertyReader();
        System.out.println(propertyReader.getProperty(propertyReader.CHROME_BINARY_LOCATION));
        System.setProperty("webdriver.chrome.driver", propertyReader.getProperty(propertyReader.CHROME_WEBDRIVER_LOCATION));
        options.setBinary(propertyReader.getProperty(propertyReader.CHROME_BINARY_LOCATION));
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void runtest() throws IOException, InterruptedException {
        LoginDetail loginDetail = loginDataReader.readLoginDetails("1", "loginData.csv").get(0);
        System.out.println(loginDetail.getUserName());
        ManualLogin manualLogin = new ManualLogin();
        manualLogin.logIn(driver,loginDetail);
        LoadMRAForm loadMRAForm = new LoadMRAForm();
        loadMRAForm.loadMRAForm(driver);
    }
}

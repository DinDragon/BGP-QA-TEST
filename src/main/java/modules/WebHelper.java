package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class WebHelper {
    public static WebElement grabElementByTextContains(WebDriver driver, String text){
        return driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    public static WebElement grabElementByTextEquals(WebDriver driver, String text){
        return driver.findElement(By.xpath("//*[text()='" + text + "']"));
    }

    public static void uploadFile(WebDriver driver, String id, String filePath){
        File file = new File(filePath);
        driver.findElement(By.id(id)).sendKeys(file.getAbsolutePath());
    }

    public static void waitForElementVisibleCSS(WebDriver driver, String cssSelector) {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }
}

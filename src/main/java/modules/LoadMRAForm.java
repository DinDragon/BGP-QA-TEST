package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoadMRAForm {
    public void loadMRAForm(WebDriver driver) throws InterruptedException {

        driver.findElement(By.cssSelector("#dashboard-menubox-app-apply-grant .dashboard-action-description")).click();
        driver.findElement(By.cssSelector(".items-container:nth-child(1) > .col-sm-new:nth-child(4) .item")).click();
        driver.findElement(By.cssSelector(".col-sm-12:nth-child(1) .itemname")).click();
        driver.findElement(By.cssSelector(".col-sm-12:nth-child(1) .itemname")).click();
        driver.findElement(By.id("go-to-grant")).click();
        driver.findElement(By.id("keyPage-form-button")).click();
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.cssSelector(".main")).click();


    }
}

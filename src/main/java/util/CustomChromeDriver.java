package util;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomChromeDriver extends ChromeDriver {

    @Override
    public WebElement findElement(By by) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JavascriptExecutor je =  (JavascriptExecutor)this;
        je.executeScript("window.scrollTo(0," + (super.findElement(by).getLocation().getY() - 100)+ ")");


        return super.findElement(by);
    }
}

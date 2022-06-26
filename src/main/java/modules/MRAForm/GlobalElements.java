package modules.MRAForm;

import constants.MRAForm.MRAFormHTMLFieldMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalElements {
    public static void clickSaveButtonAndRefresh(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id(MRAFormHTMLFieldMapper.SAVE_BUTTON_ID)).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MRAFormHTMLFieldMapper.DRAFT_SAVED_NOTICE_CSS)));
        driver.navigate().refresh();
    }

    public static void clickNextButton(WebDriver driver){
        driver.findElement(By.id(MRAFormHTMLFieldMapper.NEXT_BUTTON_ID)).click();
    }
}

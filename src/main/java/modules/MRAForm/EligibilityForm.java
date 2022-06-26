package modules.MRAForm;

import constants.Constants;
import constants.MRAForm.MRAFormHTMLFieldMapper;
import constants.MRAForm.MRAFormValidationMessages;
import model.MRAForm.EligibilityDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public final class EligibilityForm {
    public static void fillInMRAEligibility(WebDriver driver, EligibilityDetail eligibilityDetail) {
        JavascriptExecutor je =  (JavascriptExecutor)driver;
        int noSelectCount = 0;
        //EL1//
        if(eligibilityDetail.getEL1().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL1_TRUE_ID)).click();
        }else{
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL1_FALSE_ID)).click();
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;
        }
        //EL2//
        if(eligibilityDetail.getEL2().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL2_TRUE_ID)).click();
        }else{
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL2_FALSE_ID)).click();
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;

        }
        //EL3//
        je.executeScript("window.scrollTo(0," + driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL3_TRUE_ID)).getLocation()+ ")");
        if(eligibilityDetail.getEL3().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL3_TRUE_ID)).click();
        }else{

            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL3_FALSE_ID)).click();
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;
        }
        //EL4//
        if(eligibilityDetail.getEL4().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL4_TRUE_ID)).click();
        }else{
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL4_FALSE_ID)).click();
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;

        }
        //EL5//
        if(eligibilityDetail.getEL5().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL5_TRUE_ID)).click();
        }else{
            driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL5_FALSE_ID)).click();
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;

        }
        if(noSelectCount>0){
            assertTrue((driver.findElements(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).size() == noSelectCount));
            String originalWindow = driver.getWindowHandle();
            String newWindow;
            assert(driver.getWindowHandles().size() == 1);
            driver.findElement(By.linkText(MRAFormHTMLFieldMapper.ELIGIBILITY.FAQ_LINK)).click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    newWindow = driver.getWindowHandle();
                    break;
                }
            }
            assertThat(driver.getCurrentUrl(), is(MRAFormValidationMessages.ELIGIBILITY.FAQ_URL));
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }



    public static void checkMRAEligibility(WebDriver driver, EligibilityDetail eligibilityDetail){
        JavascriptExecutor je =  (JavascriptExecutor)driver;

        int noSelectCount = 0;
        //EL1//
        if(eligibilityDetail.getEL1().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL1_TRUE_ID)).isSelected());
        }else{
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL1_FALSE_ID)).isSelected());
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;
        }
        //EL2//
        if(eligibilityDetail.getEL2().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL2_TRUE_ID)).isSelected());
        }else{
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL2_FALSE_ID)).isSelected());
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;

        }
        //EL3//
        je.executeScript("window.scrollTo(0," + driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL3_TRUE_ID)).getLocation()+ ")");
        if(eligibilityDetail.getEL3().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL3_TRUE_ID)).isSelected());
        }else{
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL3_FALSE_ID)).isSelected());

            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;
        }
        //EL4//
        if(eligibilityDetail.getEL4().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL4_TRUE_ID)).isSelected());
        }else{
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL4_FALSE_ID)).isSelected());
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;

        }
        //EL5//
        je.executeScript("window.scrollTo(0," + driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL5_TRUE_ID)).getLocation()+ ")");

        if(eligibilityDetail.getEL5().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL5_TRUE_ID)).isSelected());

        }else{
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.ELIGIBILITY.EL5_FALSE_ID)).isSelected());
            assertThat(driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).getText(), is(MRAFormValidationMessages.ELIGIBILITY.NO_WARNING_MESSAGE));

            noSelectCount ++;

        }
        if(noSelectCount>0){
            assertTrue((driver.findElements(By.cssSelector(MRAFormHTMLFieldMapper.ELIGIBILITY.WARNING_MESSAGE_CSS)).size() == noSelectCount));
        }
    }
}

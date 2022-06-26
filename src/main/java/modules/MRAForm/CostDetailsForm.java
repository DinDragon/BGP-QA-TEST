package modules.MRAForm;

import constants.Constants;
import constants.MRAForm.MRAFormHTMLFieldMapper;
import constants.MRAForm.MRAFormValidationMessages;
import model.MRAForm.Cost.CostDetail;
import model.MRAForm.Cost.OfficeSpaceRentalDetail;
import model.MRAForm.Cost.ThirdPartyCostDetail;
import modules.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Util;

import java.io.File;

import static modules.WebHelper.grabElementByTextContains;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CostDetailsForm {
    public static void fillInThirdPartyVendor(WebDriver driver, CostDetail costDetail){
        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.THIRD_PARTY_HEADER_ID)).click();
        int tpcCount = 0;
        for(ThirdPartyCostDetail thirdPartyCostDetail: costDetail.getThirdPartyCostDetailList()){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ADD_THIRD_PARTY_ITEM)).click();
            if(thirdPartyCostDetail.getIsVendorSg().equals(Constants.YES_OR_NO.YES)){
                driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.IS_VENDOR_SINGAPORE_ID(tpcCount))).click();
                driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.VENDOR_NAME_ID(tpcCount))).sendKeys(thirdPartyCostDetail.getVendorName());
                driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.VENDOR_SEARCH_BUTTON_ID(tpcCount))).click();
                if(thirdPartyCostDetail.getVendorName().length()<4){
                    assertThat(
                            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ALERT.VENDOR_NAME_ALERT_ID(tpcCount))).getText(),
                            is(MRAFormValidationMessages.COSTS.VENDOR_NAME_4CHARS)
                    );
                }else if(thirdPartyCostDetail.getIsVendorNameInvalid().equals(Constants.YES_OR_NO.YES)){
                    assertThat(
                            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ALERT.VENDOR_NAME_ALERT_ID(tpcCount))).getText(),
                            is(MRAFormValidationMessages.COSTS.VENDOR_NAME_INVALID)
                    );
                }else{
                    assertThat(
                            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.VENDOR_UEN_ID(tpcCount))).getText(),
                            is(thirdPartyCostDetail.getUen())
                    );
                }
            }else{
                driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.IS_VENDOR_OVERSEAS_ID(tpcCount))).click();
                driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.VENDOR_NAME_ID(tpcCount))).sendKeys(thirdPartyCostDetail.getVendorName());
            }
            File supportingDocumentFile = new File(thirdPartyCostDetail.getSupportingDocumentLocation());
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.VENDOR_SUPPORTING_DOCUMENTS_ID(tpcCount))).sendKeys(supportingDocumentFile.getAbsolutePath());
            if(!Constants.VALID_FILE_FORMAT.contains(supportingDocumentFile.getName().split("\\.")[1])){
                assertThat(
                        driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.UPLOADED_DOCUMENTS_LOADING_MESSAGE_CSS(tpcCount,0))).getText(),
                        is(MRAFormValidationMessages.FILE_TYPE_NOT_SUPPORTED)
                );
            }else{
                WebHelper.waitForElementVisibleCSS(driver,MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.UPLOADED_DOCUMENTS_CSS(tpcCount, 0));
                assertThat(
                        driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.UPLOADED_DOCUMENTS_CSS(tpcCount, 0))).getText(),
                        containsString(supportingDocumentFile.getName())
                );
            }
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ESTIMATE_COST_CURRENCY_ID(tpcCount))).click();
            grabElementByTextContains(driver,thirdPartyCostDetail.getEstimatedCostCurrency()).click();
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ESTIMATE_COST_ID(tpcCount))).sendKeys(thirdPartyCostDetail.getEstimatedCostAmount());
            if(!thirdPartyCostDetail.getEstimatedCostCurrency().equals("SGD")){
                driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.EXCHANGE_RATE_ID(tpcCount))).sendKeys(thirdPartyCostDetail.getExchangeRate());
                double estimatedConvertedCost = Double.parseDouble(thirdPartyCostDetail.getEstimatedCostAmount()) * Double.parseDouble(thirdPartyCostDetail.getExchangeRate());
                String estimatedConvertedCostString = Util.getFloatStringFromString(String.valueOf(estimatedConvertedCost));
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ESTIMATED_COST_COMPUTED_ID(tpcCount))).getText(),
                        is("SGD " + estimatedConvertedCostString)
                );
            }else{
                String estimatedConvertedCostString = Util.getFloatStringFromString(thirdPartyCostDetail.getEstimatedCostAmount());
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ESTIMATED_COST_COMPUTED_ID(tpcCount))).getText(),
                        is("SGD " + estimatedConvertedCostString)
                );
            }
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.REMARKS_ID(tpcCount))).sendKeys(thirdPartyCostDetail.getRemarks());
            if(thirdPartyCostDetail.getRemarks().length() > 500){
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.THIRD_PARTY.ALERT.REMARKS_ALERT_ID(tpcCount))).getText(),
                        is(MRAFormValidationMessages.CHAR_LIM_REM)
                );
            }

            tpcCount ++;
        }

    }

    public static void fillInOfficeSpaceRental(WebDriver driver,CostDetail costDetail){
        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.OFFICE_SPACE_RENTAL_HEADER_ID)).click();
        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.ADD_OFFICE_SPACE_ITEM_ID)).click();
        int count=0;
        for(OfficeSpaceRentalDetail officeSpaceRentalDetail: costDetail.getOfficeSpaceRentalList()){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.DESCRIPTION_ID(count))).sendKeys(officeSpaceRentalDetail.getDescription());
            if(officeSpaceRentalDetail.getDescription().length() > 500){
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.ALERT.DESCRIPTION_ID(count))).getText(),
                        is(MRAFormValidationMessages.CHAR_LIM_REM)
                );
            }

            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.RENTAL_DURATION_ID(count))).sendKeys(officeSpaceRentalDetail.getRentalDuration());
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.MONTHLY_CURRENCY_ID(count))).click();
            WebHelper.grabElementByTextContains(driver,officeSpaceRentalDetail.getMonthyRentalCurrency()).click();
            driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.MONTHLY_RENTAL_AMOUNT_ID(count))).sendKeys(officeSpaceRentalDetail.getMontlyRentalAmount());
            if(officeSpaceRentalDetail.getMonthyRentalCurrency().equals("SGD")){
                assertTrue(
                        "MRAFORM-COST-OFFICESPACERENTAL-EXCHANGERATE: Exchange rate should be displayed when currency is not SGD. PASSED.",
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.EXCHANGE_RATE_ID(count))).isDisplayed()
                );
                driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.EXCHANGE_RATE_ID(count))).sendKeys(officeSpaceRentalDetail.getExchangeRate());
                double estimatedConvertedCost = Double.parseDouble(officeSpaceRentalDetail.getMontlyRentalAmount()) * Double.parseDouble(officeSpaceRentalDetail.getExchangeRate()) * Double.parseDouble(officeSpaceRentalDetail.getRentalDuration());
                String estimatedConvertedCostString = Util.getFloatStringFromString(String.valueOf(estimatedConvertedCost));
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.COSTS.OFFICE_SPACE_RENTAL.MONTHLY_RENTAL_ESTIMATED_COST_ID(count))).getText(),
                        is("SGD " + estimatedConvertedCostString)
                );
            }

        }

    }
}

package modules.MRAForm;

import constants.MRAForm.MRAFormHTMLFieldMapper;
import constants.MRAForm.MRAFormValidationMessages;
import model.MRAForm.BusinessImpactDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BusinessImpactForm {
    public static void fillInBusinessImpactDetails(WebDriver driver, BusinessImpactDetail businessImpactDetail){

        //key in and check FYEend date
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_1_ID)).sendKeys(businessImpactDetail.getFYEndDate());
        if(!Util.validateJavaDate(businessImpactDetail.getFYEndDate(), MRAFormValidationMessages.DATE_FORMAT)){
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.FY_END_DATE_1_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.INVALID_DATE)
            );
        }else{
            LocalDate fyEndDate = Util.convertStringToDate(businessImpactDetail.getFYEndDate(), MRAFormValidationMessages.DATE_FORMAT);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(MRAFormValidationMessages.DATE_FORMAT);
            LocalDate fyEndDate2 = fyEndDate.plusYears(1);
            LocalDate fyEndDate3 = fyEndDate.plusYears(2);
            LocalDate fyEndDate4 = fyEndDate.plusYears(3);
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_2_ID)).getText(),
                    is(fyEndDate2.format(dtf))
            );
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_3_ID)).getText(),
                    is(fyEndDate3.format(dtf))
            );
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_4_ID)).getText(),
                    is(fyEndDate4.format(dtf))
            );
            LocalDate currentDate = LocalDate.now();
            LocalDate last2Year = currentDate.minusYears(2);

            if(fyEndDate.getYear() > currentDate.getYear() || fyEndDate.getYear() < last2Year.getYear()){
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.FY_END_DATE_1_ALERT_ID)).getText(),
                        is(MRAFormValidationMessages.BUSINESS_IMPACT.generateFYEndDateYearLimitMessage())
                );
            }
        }

        //Key in overseas sales
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_1_ID)).sendKeys(businessImpactDetail.getOverseasSale1());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_2_ID)).sendKeys(businessImpactDetail.getOverseasSale2());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_3_ID)).sendKeys(businessImpactDetail.getOverseasSale3());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_4_ID)).sendKeys(businessImpactDetail.getOverseasSale4());

        //Key in overseas investments
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_1_ID)).sendKeys(businessImpactDetail.getOverseasInvestments1());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_2_ID)).sendKeys(businessImpactDetail.getOverseasInvestments2());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_3_ID)).sendKeys(businessImpactDetail.getOverseasInvestments3());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_4_ID)).sendKeys(businessImpactDetail.getOverseasInvestments4());

        //Rationale for projections
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.RATIONALE_FOR_PROJECTIONS_ID)).sendKeys(businessImpactDetail.getRationaleForProjections());
        if(businessImpactDetail.getRationaleForProjections().length() > 500){
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.RATIONALE_FOR_PROJECTIONS_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.CHAR_LIM_REM)
            );
        }

        //Non tangible benefits
        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.NON_TANGIBLE_BENEFITS_ID)).sendKeys(businessImpactDetail.getNonTangibleBenefits());
        if(businessImpactDetail.getNonTangibleBenefits().length() > 500){
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.NON_TANGIBLE_BENEFITS_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.CHAR_LIM_REM)
            );
        }
    }

    public static void checkInBusinessImpactDetails(WebDriver driver, BusinessImpactDetail businessImpactDetail){

        //key in and check FYEend date
        assertThat(
            driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_1_ID)).getAttribute("value"),
            is(businessImpactDetail.getFYEndDate())
        );

        if(!Util.validateJavaDate(businessImpactDetail.getFYEndDate(), MRAFormValidationMessages.DATE_FORMAT)){
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.FY_END_DATE_1_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.INVALID_DATE)
            );
        }else{
            LocalDate fyEndDate = Util.convertStringToDate(businessImpactDetail.getFYEndDate(), MRAFormValidationMessages.DATE_FORMAT);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(MRAFormValidationMessages.DATE_FORMAT);
            LocalDate fyEndDate2 = fyEndDate.plusYears(1);
            LocalDate fyEndDate3 = fyEndDate.plusYears(2);
            LocalDate fyEndDate4 = fyEndDate.plusYears(3);
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_2_ID)).getText(),
                    is(fyEndDate2.format(dtf))
            );
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_3_ID)).getText(),
                    is(fyEndDate3.format(dtf))
            );
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.FY_END_DATE_4_ID)).getText(),
                    is(fyEndDate4.format(dtf))
            );
            LocalDate currentDate = LocalDate.now();
            LocalDate last2Year = currentDate.minusYears(2);

            if(fyEndDate.getYear() > currentDate.getYear() || fyEndDate.getYear() < last2Year.getYear()){
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.FY_END_DATE_1_ALERT_ID)).getText(),
                        is(MRAFormValidationMessages.BUSINESS_IMPACT.generateFYEndDateYearLimitMessage())
                );
            }
        }

        //Key in overseas sales
        assertThat(
            driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_1_ID)).getAttribute("value"),
            is(Util.getFloatStringFromString(businessImpactDetail.getOverseasSale1()))
        );
        assertThat(
            driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_2_ID)).getAttribute("value"),
            is(Util.getFloatStringFromString(businessImpactDetail.getOverseasSale2()))
        );
        assertThat(
            driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_3_ID)).getAttribute("value"),
            is(Util.getFloatStringFromString(businessImpactDetail.getOverseasSale3()))
        );
        assertThat(
            driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_SALES_4_ID)).getAttribute("value"),
            is(Util.getFloatStringFromString(businessImpactDetail.getOverseasSale4()))
        );

        //Key in overseas investments
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_1_ID)).getAttribute("value"),
                is(Util.getFloatStringFromString(businessImpactDetail.getOverseasInvestments1()))
        );
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_2_ID)).getAttribute("value"),
                is(Util.getFloatStringFromString(businessImpactDetail.getOverseasInvestments2()))
        );
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_3_ID)).getAttribute("value"),
                is(Util.getFloatStringFromString(businessImpactDetail.getOverseasInvestments3()))
        );
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.OVERSEAS_INVESTMENTS_4_ID)).getAttribute("value"),
                is(Util.getFloatStringFromString(businessImpactDetail.getOverseasInvestments4()))
        );


        //Rationale for projections
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.RATIONALE_FOR_PROJECTIONS_ID)).getAttribute("value"),
                is(businessImpactDetail.getRationaleForProjections())
        );
        if(businessImpactDetail.getRationaleForProjections().length() > 500){
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.RATIONALE_FOR_PROJECTIONS_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.CHAR_LIM_REM)
            );
        }

        //Non tangible benefits
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.NON_TANGIBLE_BENEFITS_ID)).getAttribute("value"),
                is(businessImpactDetail.getNonTangibleBenefits())
        );
        if(businessImpactDetail.getNonTangibleBenefits().length() > 500){
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.BUSINESS_IMPACT.ALERT.NON_TANGIBLE_BENEFITS_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.CHAR_LIM_REM)
            );
        }
    }

}

package modules.MRAForm;

import constants.Constants;
import constants.MRAForm.MRAFormHTMLFieldMapper;
import constants.MRAForm.MRAFormValidationMessages;
import model.MRAForm.ProposalDetail;
import modules.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProposalForm {
    public static void fillInProposalDetails(WebDriver driver, ProposalDetail proposalDetail) throws IOException, InterruptedException {
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_TITLE_ID)).sendKeys(proposalDetail.getProjectTitle());

        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.START_DATE_ID)).sendKeys(proposalDetail.getStartDate());
        if(!Util.validateJavaDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT)){
            //Test start date is invalid message
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.START_DATE_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.INVALID_DATE));
        }else{
            //check start date must be greater than or equal to current date message
            LocalDate startDate = Util.convertStringToDate(proposalDetail.getStartDate(),MRAFormValidationMessages.DATE_FORMAT);
            LocalDate currentDate = LocalDate.now();
            if(startDate.isBefore(currentDate)){
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.START_DATE_ALERT_ID)).getText(),
                        is(MRAFormValidationMessages.PROPOSAL.START_DATE_MUST_BE_TODAY_OR_LATER)
                );
            }
        }

        driver.findElement(By.id((MRAFormHTMLFieldMapper.PROPOSAL.END_DATE_ID))).sendKeys(proposalDetail.getEndDate());
        if(!Util.validateJavaDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT)){
            //test end date invalid message
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.END_DATE_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.INVALID_DATE));
        }else{
            if(Util.validateJavaDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT)){
                LocalDate startDate = Util.convertStringToDate(proposalDetail.getStartDate(),MRAFormValidationMessages.DATE_FORMAT);
                LocalDate endDate = Util.convertStringToDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT);
               if(endDate.isBefore(startDate)){
                   //check end date must be greater than or equal to current date and start date message
                   assertThat(
                           driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.END_DATE_ALERT_ID)),
                           is(MRAFormValidationMessages.PROPOSAL.END_DATE_EARLIER_THAN_START)
                   );
               }else if(Util.monthsBetweenDates(startDate, endDate) > 12){
                   //test end date error message for duration more than 12 months
                   assertThat(
                           driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.END_DATE_ALERT_ID)).getText(),
                           is(MRAFormValidationMessages.PROPOSAL.PROJECT_DURATION_12_MONTHS_OR_LESS)
                   );
               }
            }
        }

        //test Project duration displaying correct number of months
        if(Util.validateJavaDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT) && Util.validateJavaDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT)){
            LocalDate startDate = Util.convertStringToDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT);
            LocalDate endDate = Util.convertStringToDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT);

            assertThat(
                    driver.findElement(By.xpath(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_DURATION_XPATH)).getText(),
                    is(MRAFormValidationMessages.PROPOSAL.generateDurationString(startDate, endDate)));
        }
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_DESCRIPTION_ID)).click();

        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_DESCRIPTION_ID)).sendKeys(proposalDetail.getProjectDescription());
        //test if description greater than 4000 words display error message
        if(proposalDetail.getProjectDescription().length() > 4000){
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.PROJECT_DESCRIPTION_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.PROPOSAL.CHAR_LIM_DESC)
            );
        }

        //Activity select
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ACTIVITY_ID)).click();
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ACTIVITY_SELECT_MENU_ID.get(proposalDetail.getActivity().toUpperCase()))).click();

        //Target market select
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.TARGET_MARKET_ID)).click();
        WebHelper.grabElementByTextEquals(driver, proposalDetail.getTargetMarket()).click();

        //first time target market select
        if(proposalDetail.getFirstTimeApplication().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.FIRST_TIME_TRUE_ID)).click();
        }else if(proposalDetail.getFirstTimeApplication().equals(Constants.YES_OR_NO.NO)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.FIRST_TIME_FALSE_ID)).click();
        }

        //supporting document
        WebHelper.uploadFile(driver,MRAFormHTMLFieldMapper.PROPOSAL.SUPPORTING_DOCUMENT_INPUT_ID, proposalDetail.getSupportingDocumentLocation());
        File tempFile = new File(proposalDetail.getSupportingDocumentLocation());
        assertThat(
                driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.PROPOSAL.UPLOADED_DOCUMENT_LINK_0_CSS)).getText(),
                is(tempFile.getName())
        );
        //remarks
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.REMARKS_ID)).click();
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.REMARKS_ID)).sendKeys(proposalDetail.getRemarks());
        if(proposalDetail.getRemarks().length() > 500){
            //test if remarks bigger than 500 should display error message
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.REMARKS_ALERT_ID)),
                    is(MRAFormValidationMessages.CHAR_LIM_REM)
            );
        }
    }

    public static void checkProposalDetails(WebDriver driver, ProposalDetail proposalDetail) throws IOException, InterruptedException {
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_TITLE_ID)).getAttribute("value"),
                is(proposalDetail.getProjectTitle())
        );

        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.START_DATE_ID)).getAttribute("value"),
                is(proposalDetail.getStartDate())
        );
        if(!Util.validateJavaDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT)){
            //Test start date is invalid message
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.START_DATE_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.INVALID_DATE));
        }else{
            //check start date must be greater than or equal to current date message
            LocalDate startDate = Util.convertStringToDate(proposalDetail.getStartDate(),MRAFormValidationMessages.DATE_FORMAT);
            LocalDate currentDate = LocalDate.now();
            if(startDate.isBefore(currentDate)){
                assertThat(
                        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.START_DATE_ALERT_ID)).getText(),
                        is(MRAFormValidationMessages.PROPOSAL.START_DATE_MUST_BE_TODAY_OR_LATER)
                );
            }
        }

        assertThat(
                driver.findElement(By.id((MRAFormHTMLFieldMapper.PROPOSAL.END_DATE_ID))).getAttribute("value"),
                is(proposalDetail.getEndDate())
        );
        if(!Util.validateJavaDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT)){
            //test end date invalid message
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.END_DATE_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.INVALID_DATE));
        }else{
            if(Util.validateJavaDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT)){
                LocalDate startDate = Util.convertStringToDate(proposalDetail.getStartDate(),MRAFormValidationMessages.DATE_FORMAT);
                LocalDate endDate = Util.convertStringToDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT);
                if(endDate.isBefore(startDate)){
                    //check end date must be greater than or equal to current date and start date message
                    assertThat(
                            driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.END_DATE_ALERT_ID)),
                            is(MRAFormValidationMessages.PROPOSAL.END_DATE_EARLIER_THAN_START)
                    );
                }else if(Util.monthsBetweenDates(startDate, endDate) > 12){
                    //test end date error message for duration more than 12 months
                    assertThat(
                            driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.END_DATE_ALERT_ID)).getText(),
                            is(MRAFormValidationMessages.PROPOSAL.PROJECT_DURATION_12_MONTHS_OR_LESS)
                    );
                }
            }
        }

        //test Project duration displaying correct number of months
        if(Util.validateJavaDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT) && Util.validateJavaDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT)){
            LocalDate startDate = Util.convertStringToDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT);
            LocalDate endDate = Util.convertStringToDate(proposalDetail.getEndDate(), MRAFormValidationMessages.DATE_FORMAT);

            assertThat(
                    driver.findElement(By.xpath(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_DURATION_XPATH)).getText(),
                    is(MRAFormValidationMessages.PROPOSAL.generateDurationString(startDate, endDate)));
        }

        //project description
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_DESCRIPTION_ID)).getAttribute("value"),
                is(proposalDetail.getProjectDescription())
        );
        //test if description greater than 4000 words display error message
        if(proposalDetail.getProjectDescription().length() > 4000){
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.PROJECT_DESCRIPTION_ALERT_ID)).getText(),
                    is(MRAFormValidationMessages.PROPOSAL.CHAR_LIM_DESC)
            );
        }

        //Activity select
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ACTIVITY_SELECTED_VALUE_ID)).getText().toUpperCase(),
                is(proposalDetail.getActivity().toUpperCase())
        );

        //Target market select
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.TARGET_MARKET_SELECTED_VALUE_ID)).getText(),
                is(proposalDetail.getTargetMarket())
        );
        //first time target market select
        if(proposalDetail.getFirstTimeApplication().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.FIRST_TIME_TRUE_ID)).isSelected());
        }else if(proposalDetail.getFirstTimeApplication().equals(Constants.YES_OR_NO.NO)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.FIRST_TIME_FALSE_ID)).isSelected());
        }

        //supporting document
        File tempFile = new File(proposalDetail.getSupportingDocumentLocation());
        assertThat(
                driver.findElement(By.cssSelector(MRAFormHTMLFieldMapper.PROPOSAL.UPLOADED_DOCUMENT_LINK_0_CSS)).getText(),
                is(tempFile.getName())
        );
        //remarks
        assertThat(
                driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.REMARKS_ID)).getAttribute("value"),
                is(proposalDetail.getRemarks())
        );
        if(proposalDetail.getRemarks().length() > 500){
            //test if remarks bigger than 500 should display error message
            assertThat(
                    driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.ALERT.REMARKS_ALERT_ID)),
                    is(MRAFormValidationMessages.CHAR_LIM_REM)
            );
        }
    }



}

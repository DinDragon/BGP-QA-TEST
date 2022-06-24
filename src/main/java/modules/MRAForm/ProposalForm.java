package modules.MRAForm;

import constants.MRAForm.MRAFormHTMLFieldMapper;
import constants.MRAForm.MRAFormValidationMessages;
import model.MRAForm.ProposalDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Util;

public class ProposalForm {
    public static void fillInProposalDetails(WebDriver driver, ProposalDetail proposalDetail){
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.PROJECT_TITLE_ID)).sendKeys(proposalDetail.getProjectTitle());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.PROPOSAL.START_DATE_ID)).sendKeys(proposalDetail.getStartDate());
        if(!Util.validateJavaDate(proposalDetail.getStartDate(), MRAFormValidationMessages.DATE_FORMAT)){

        }
    }
}

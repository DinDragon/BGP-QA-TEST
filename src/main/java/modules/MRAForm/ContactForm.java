package modules.MRAForm;

import constants.Constants;
import constants.MRAForm.MRAFormHTMLFieldMapper;
import model.LoginDetail;
import model.MRAForm.ContactDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public final class ContactForm {
    public static void fillInMainContactPerson(WebDriver driver, ContactDetail contactDetail){
        driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.NAME_ID)).sendKeys(contactDetail.getName());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.JOB_ID)).sendKeys(contactDetail.getJobTitle());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.CONTACT_NO_ID)).sendKeys(contactDetail.getContactNumber());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.EMAIL_ID)).sendKeys(contactDetail.getEmailAddress());
        driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.ALT_EMAIL_ID)).sendKeys(contactDetail.getAltEmailAddress());
    }

    public static void checkMainContactPerson(WebDriver driver, ContactDetail contactDetail){
        assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.NAME_ID)).getAttribute("value"), is(contactDetail.getName()));
        assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.JOB_ID)).getAttribute("value"), is(contactDetail.getJobTitle()));
        assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.CONTACT_NO_ID)).getAttribute("value"), is(contactDetail.getContactNumber()));
        assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.EMAIL_ID)).getAttribute("value"), is(contactDetail.getEmailAddress()));
        assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIN_CONTACT_PERSON.ALT_EMAIL_ID)).getAttribute("value"), is(contactDetail.getAltEmailAddress()));
    }

    public static void fillInMailingAddress(WebDriver driver, ContactDetail contactDetail, LoginDetail loginDetail){
        if(contactDetail.getIsMailAddrSame().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.IS_MAIL_ADD_SAME_ID)).click();
            //test Mailing addresss is disabled when select address is same as Company Profile
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.POSTAL_CODE_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.STREET_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.LEVEL_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.UNIT_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BUILDING_ID)).isEnabled());

            //Test data matches login data
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.POSTAL_CODE_ID)).getAttribute("value"), is(loginDetail.getPostalCode()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).getAttribute("value"), is(loginDetail.getBlkHseNo()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.STREET_ID)).getAttribute("value"), is(loginDetail.getStreet().toUpperCase()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.LEVEL_ID)).getAttribute("value"), is(loginDetail.getLevel()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.UNIT_ID)).getAttribute("value"), is(loginDetail.getUnit()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BUILDING_ID)).getAttribute("value"), is(loginDetail.getBuildingName()));

        }else{
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.POSTAL_CODE_ID)).sendKeys(contactDetail.getPostalCode());
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.POSTAL_CODE_SEARCH_BTN_ID)).click();
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).isEnabled());

            if(!contactDetail.getBlkHouseNo().isEmpty()){
                assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).getAttribute("value"), is(contactDetail.getBlkHouseNo()));
            }
            if(!contactDetail.getStreet().isEmpty()){
                assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.STREET_ID)).getAttribute("value"), is(contactDetail.getStreet().toUpperCase()));
            }
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.LEVEL_ID)).sendKeys(contactDetail.getLevel());
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.UNIT_ID)).sendKeys(contactDetail.getUnit());
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BUILDING_ID)).sendKeys(contactDetail.getBuildingName());
        }
    }

    public static void checkMailingAddress(WebDriver driver, ContactDetail contactDetail, LoginDetail loginDetail){
        if(contactDetail.getIsMailAddrSame().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.IS_MAIL_ADD_SAME_ID)).isSelected());
            //test Mailing addresss is disabled when select address is same as Company Profile
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.POSTAL_CODE_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.STREET_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.LEVEL_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.UNIT_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BUILDING_ID)).isEnabled());

            //Test data matches login data
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.POSTAL_CODE_ID)).getAttribute("value"), is(loginDetail.getPostalCode()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).getAttribute("value"), is(loginDetail.getBlkHseNo()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.STREET_ID)).getAttribute("value"), is(loginDetail.getStreet().toUpperCase()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.LEVEL_ID)).getAttribute("value"), is(loginDetail.getLevel()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.UNIT_ID)).getAttribute("value"), is(loginDetail.getUnit()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BUILDING_ID)).getAttribute("value"), is(loginDetail.getBuildingName()));

        }else{
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.POSTAL_CODE_ID)).getAttribute("value"), is(contactDetail.getPostalCode()));
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).isEnabled());

            if(!contactDetail.getBlkHouseNo().isEmpty()){
                assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BLOCK_HOUSE_NO_ID)).getAttribute("value"), is(contactDetail.getBlkHouseNo()));
            }
            if(!contactDetail.getStreet().isEmpty()){
                assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.STREET_ID)).getAttribute("value"), is(contactDetail.getStreet().toUpperCase()));
            }
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.LEVEL_ID)).getAttribute("value"), is(contactDetail.getLevel()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.UNIT_ID)).getAttribute("value"), is(contactDetail.getUnit()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.MAIL_ADD.BUILDING_ID)).getAttribute("value"), is(contactDetail.getBuildingName()));
        }
    }

    public static void fillInLetterOfOffer(WebDriver driver, ContactDetail contactDetail){
        if(contactDetail.getIsLOASame().equals(Constants.YES_OR_NO.YES)){
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.IS_LOA_SAME_ID)).click();
            //check fields are disabled
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_NAME_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_JOB_TITLE_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_EMAIL_ID)).isEnabled());

            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_NAME_ID)).getAttribute("value"), is(contactDetail.getName()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_JOB_TITLE_ID)).getAttribute("value"), is(contactDetail.getJobTitle()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_EMAIL_ID)).getAttribute("value"), is(contactDetail.getEmailAddress()));

        }else{
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_NAME_ID)).sendKeys(contactDetail.getLOAName());
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_JOB_TITLE_ID)).sendKeys(contactDetail.getLOAJobTitle());
            driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_EMAIL_ID)).sendKeys(contactDetail.getLOAEmail());
        }
    }

    public static void checkLetterOffOfffer(WebDriver driver, ContactDetail contactDetail){
        if(contactDetail.getIsLOASame().equals(Constants.YES_OR_NO.YES)){
            assertTrue(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.IS_LOA_SAME_ID)).isSelected());
            //check fields are disabled
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_NAME_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_JOB_TITLE_ID)).isEnabled());
            assertTrue(!driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_EMAIL_ID)).isEnabled());

            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_NAME_ID)).getAttribute("value"), is(contactDetail.getName()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_JOB_TITLE_ID)).getAttribute("value"), is(contactDetail.getJobTitle()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_EMAIL_ID)).getAttribute("value"), is(contactDetail.getEmailAddress()));

        }else{
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_NAME_ID)).getAttribute("value"), is(contactDetail.getLOAName()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_JOB_TITLE_ID)).getAttribute("value"), is(contactDetail.getLOAJobTitle()));
            assertThat(driver.findElement(By.id(MRAFormHTMLFieldMapper.CONTACT.LETTER_OF_OFFER_ADDRESSEE.LOA_EMAIL_ID)).getAttribute("value"), is(contactDetail.getLOAEmail()));
        }
    }


}

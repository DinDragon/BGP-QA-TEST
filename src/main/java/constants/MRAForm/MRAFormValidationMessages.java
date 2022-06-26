package constants.MRAForm;

import util.Util;

import java.time.LocalDate;

public final class MRAFormValidationMessages {

    public final static String INVALID_DATE = "This date doesn't look right";

    public final static String INVALID_EMAIL = "Oops, that doesn't seem like a valid email address";
    public final static String MANDATORY_FIELD = "We need a response for this field";
    public final static String DATE_FORMAT = "dd MMM yyyy";
    public final static String CHAR_LIM_REM = "Your entry shouldn't be more than 500 characters";
    public final static String FILE_TYPE_NOT_SUPPORTED = "File type is not supported";

    public final class ELIGIBILITY{
        //public final static String NO_WARNING_MESSAGE = "Visit Smart Advisor on the SME Portal for more information on other government assistance.";
        public final static String NO_WARNING_MESSAGE = "The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants.";
        public final static String FAQ_URL = "https://www.gobusiness.gov.sg/business-grants-portal-faq/";
    }

    public final class PROPOSAL{
        public final static String CHAR_LIM_DESC = "Your entry shouldn't be more than 4000 characters";
        public final static String START_DATE_MUST_BE_TODAY_OR_LATER = "Must be today or later";
        public final static String END_DATE_EARLIER_THAN_START = "The end date should be later than the start date";
        public final static String PROJECT_DURATION_12_MONTHS_OR_LESS = "Your project duration should be 12 months or less";
        public static String generateDurationString(LocalDate startDate, LocalDate endDate){
            long duration = Util.monthsBetweenDates(startDate,endDate);
            String durationString;
            if(duration == 1){
                durationString = String.valueOf(duration) + " month";
            }else{
                durationString = String.valueOf(duration) + " months";
            }
            return durationString;
        }
    }

    public final class BUSINESS_IMPACT{
        public static String generateFYEndDateYearLimitMessage(){
            LocalDate currentDate = LocalDate.now();
            LocalDate lastYear = currentDate.minusYears(1);
            LocalDate last2Year = currentDate.minusYears(2);

            String message = "This should be " + currentDate.getYear() + " or " + lastYear.getYear() + " or " + last2Year.getYear() + ".";
            return message;
        };
    }

    public final class COSTS{
        public final static String VENDOR_NAME_INVALID = "This vendor's name appears to be invalid, please check your entry and try again";
        public final static String VENDOR_NAME_4CHARS = "Oops, your search requires at least 4 characters";
    }




}

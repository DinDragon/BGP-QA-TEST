package constants;

import java.util.ArrayList;
import java.util.List;

public final class Constants {
    public static final String  LIST_OF_STRING_DELIMITER = "/";
    public static final String SECRET_KEY = "09384yruwerhgoiu";
    public static final ArrayList<String> VALID_FILE_FORMAT = new ArrayList<String>(){
        {
            add("pdf");
            add("PDF");
        }
    };
    public final class PROPERTY_VARIABLE{
        public static final String PROPERTY_FILE_LOCATION = "src/main/resources/Properties/config.properties";
        public static final String CHROME_BINARY_LOCATION = "chromeBinaryLocation";
        public static final String CHROME_WEBDRIVER_LOCATION = "chromeWebDriverLocation";
        public static final String BASE_URL = "baseUrl";
        public static final String SERVER_LOGIN_USERNAME = "serverLoginUsername";
        public static final String SERVER_LOGIN_PASSWORD = "serverLoginPassword";
        public static final String FILE_UPLOAD_SCRIPT_LOCATION = "fileUploadScript";
    }

    public final class DATA_FILE_NAME{
        public static final String LOGIN_DATA_FILE_NAME = "loginData.csv";
        public static final String ELIGIBILITY_DETAIL_FILE_NAME = "EligibilityDetail.csv";
        public static final String CONTACT_DETAIL_FILE_NAME = "ContactDetail.csv";

        public static final String BUSINESS_IMPACT_FILE_NAME = "BusinessImpactDetail.csv";
        public static final String COST_DETAIL_FILE_NAME = "CostDetails.csv";
        public static final String OFFICE_SPACE_RENTAL_DETAIL = "OfficeSpaceRentalDetail.csv";
        public static final String PROPOSAL_DETAIL_FILE_NAME = "ProposalDetail.csv";
        public static final String SALARY_DETAIL_FILE_NAME = "SalaryDetail.csv";
        public static final String THIRD_PARTY_COST_DETAIL = "ThirdPartyCostDetail.csv";

    }

    public final class YES_OR_NO{
        public static final String YES = "Y";
        public static final String NO = "N";
    }
}

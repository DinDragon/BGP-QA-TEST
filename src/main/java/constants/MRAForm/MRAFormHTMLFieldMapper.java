package constants.MRAForm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class MRAFormHTMLFieldMapper {
    //General elements
    public final static String NEXT_BUTTON_ID = "next-btn";
    public final static String SAVE_BUTTON_ID = "save-btn";
    public final static String PREVIOUS_BUTTON_ID = "back-btn";
    public final static String DRAFT_SAVED_NOTICE_CSS = ".growl-notice";

    public final class ELIGIBILITY{
        public final static String EL1_TRUE_ID = "react-eligibility-sg_registered_check-true";
        public final static String EL1_FALSE_ID = "react-eligibility-sg_registered_check-false";
        public final static String WARNING_MESSAGE_CSS = ".field-warning-text > span";
        public final static String FAQ_LINK = "FAQ";
        public final static String EL2_TRUE_ID = "react-eligibility-turnover_check-true";
        public final static String EL2_FALSE_ID = "react-eligibility-turnover_check-false";
        public final static String EL3_TRUE_ID = "react-eligibility-global_hq_check-true";
        public final static String EL3_FALSE_ID = "react-eligibility-global_hq_check-false";
        public final static String EL4_TRUE_ID = "react-eligibility-new_target_market_check-true";
        public final static String EL4_FALSE_ID = "react-eligibility-new_target_market_check-false";
        public final static String EL5_TRUE_ID = "react-eligibility-started_project_check-true";
        public final static String EL5_FALSE_ID = "react-eligibility-started_project_check-false";

        public final class ALERT{
            public final static String EL1_ALERT_ID = "react-eligibility-sg_registered_check-alert";
            public final static String EL2_ALERT_ID = "react-eligibility-turnover_check-alert";
            public final static String EL3_ALERT_ID = "react-eligibility-global_hq_check-alert";
            public final static String EL4_ALERT_ID = "react-eligibility-new_target_market_check-alert";
            public final static String EL5_ALERT_ID = "react-eligibility-started_project_check-alert";
        }

    }

    public final class CONTACT{

        public final class MAIN_CONTACT_PERSON{
            public final static String NAME_ID = "react-contact_info-name";
            public final static String JOB_ID = "react-contact_info-designation";
            public final static String CONTACT_NO_ID = "react-contact_info-phone";
            public final static String EMAIL_ID = "react-contact_info-primary_email";
            public final static String ALT_EMAIL_ID = "react-contact_info-secondary_email";
            public final class ALERT{
                public final static String NAME_ALERT_ID = "react-contact_info-name-alert";
                public final static String JOB_ALERT_ID = "react-contact_info-designation-alert";
                public final static String CONTACT_NO_ALERT_ID = "react-contact_info-phone-alert";
                public final static String EMAIL_ALERT_ID = "react-contact_info-primary_email-alert";
                public final static String ALT_EMAIL_ALERT_ID = "react-contact_info-secondary_email-alert";
            }
        }
        public final class MAIL_ADD{
            public final static String IS_MAIL_ADD_SAME_ID = "react-contact_info-correspondence_address-copied";
            public final static String POSTAL_CODE_ID = "react-contact_info-correspondence_address-postal";
            public final static String POSTAL_CODE_SEARCH_BTN_ID = "react-contact_info-correspondence_address-postal-postal";
            public final static String BLOCK_HOUSE_NO_ID = "react-contact_info-correspondence_address-block";
            public final static String STREET_ID = "react-contact_info-correspondence_address-street";
            public final static String LEVEL_ID = "react-contact_info-correspondence_address-level";
            public final static String UNIT_ID = "react-contact_info-correspondence_address-unit";
            public final static String BUILDING_ID = "react-contact_info-correspondence_address-building_name";
            public final class ALERT{

            }
        }
        public final class LETTER_OF_OFFER_ADDRESSEE {
            public final static String IS_LOA_SAME_ID = "react-contact_info-copied";
            public final static String LOA_NAME_ID = "react-contact_info-offeree_name";
            public final static String LOA_JOB_TITLE_ID = "react-contact_info-offeree_designation";
            public final static String LOA_EMAIL_ID = "react-contact_info-offeree_email";
            public final class ALERT{

            }
        }
    }
    public final class PROPOSAL{
        public final static String PROJECT_TITLE_ID = "react-project-title";
        public final static String START_DATE_ID = "react-project-start_date";
        public final static String END_DATE_ID = "react-project-end_date";
        public final static String PROJECT_DURATION_XPATH = "//*[contains(text(),' month')]";
        public final static String PROJECT_DESCRIPTION_ID = "react-project-description";
        public final static String ACTIVITY_ID = "react-select-project-activity--value";
        public final static String ACTIVITY_SELECTED_VALUE_ID = "react-select-project-activity--value-item";
        public final static Map<String, String> ACTIVITY_SELECT_MENU_ID;
        static{
            Map<String, String> aMap = new HashMap<String, String>();
            aMap.put("FTA CONSULTANCY", "react-select-project-activity--option-0");
            aMap.put("MARKET ENTRY", "react-select-project-activity--option-1");
            aMap.put("IDENTIFICATION OF POTENTIAL OVERSEAS PARTNERS", "react-select-project-activity--option-2");
            aMap.put("IN MARKET BUSINESS DEVELOPMENT", "react-select-project-activity--option-3");
            aMap.put("OVERSEAS MARKETING PRESENCE", "react-select-project-activity--option-4");
            aMap.put("OVERSEAS MARKETING AND PR ACTIVITIES", "react-select-project-activity--option-5");
            aMap.put("OVERSEAS PHYSICAL AND VIRTUAL TRADE FAIRS", "react-select-project-activity--option-6");
            ACTIVITY_SELECT_MENU_ID = Collections.unmodifiableMap(aMap);
        }
        public final static String TARGET_MARKET_ID = "react-select-project-primary_market--value";
        public final static String TARGET_MARKET_SELECTED_VALUE_ID = "react-select-project-primary_market--value-item";
//        public final static Map<String, String> TARGET_SELECT_MENU_ID;
//        static{
//            Map<String, String> aMap = new HashMap<String, String>();
//            aMap.put("FTA CONSULTANCY", "react-select-project-primary_market--option-0");
//            aMap.put("MARKET ENTRY", "react-select-project-primary_market--option-1");
//            aMap.put("IDENTIFICATION OF POTENTIAL OVERSEAS PARTNERS", "react-select-primary_market--option-2");
//            aMap.put("IN MARKET BUSINESS DEVELOPMENT", "react-select-primary_market--option-3");
//            aMap.put("OVERSEAS MARKETING PRESENCE", "react-select-primary_market--option-4");
//            aMap.put("OVERSEAS MARKETING AND PR ACTIVITIES", "react-select-primary_market--option-5");
//            aMap.put("OVERSEAS PHYSICAL AND VIRTUAL TRADE FAIRS", "react-select-primary_market--option-6");
//            TARGET_SELECT_MENU_ID = Collections.unmodifiableMap(aMap);
//        }
        public final static String FIRST_TIME_TRUE_ID = "react-project-is_first_time_expand-true";
        public final static String FIRST_TIME_FALSE_ID = "react-project-is_first_time_expand-false";
        public final static String SUPPORTING_DOCUMENT_BUTTON_ID = "react-project-attachments-btn";
        public final static String SUPPORTING_DOCUMENT_INPUT_ID = "react-project-attachments-input";
        public final static String UPLOADED_DOCUMENT_LINK_0_CSS = "#react-project-attachments-0-attachment-row > table > tr > td.bgp-attachment-icon";
        public final static String UPLOADED_DOCUMENT_LINK_1_CSS = "#react-project-attachments-1-attachment-row > table > tr > td.bgp-attachment-icon";
        public final static String UPLOADED_DOCUMENT_LINK_2_CSS = "#react-project-attachments-2-attachment-row > table > tr > td.bgp-attachment-icon";
        public final static String REMARKS_ID = "react-project-remarks";


        public final class ALERT{
            public final static String PROJECT_TITLE_ALERT_ID = "react-project-title-alert";
            public final static String START_DATE_ALERT_ID = "react-project-start_date-alert";
            public final static String END_DATE_ALERT_ID = "react-project-end_date-alert";
            public final static String PROJECT_DESCRIPTION_ALERT_ID = "react-project-description-alert";
            public final static String ACTIVITY_ALERT_ID = "react-project-activity-alert";
            public final static String TARGET_MARKET_ALERT_ID = "react-project-primary_market-alert";
            public final static String FIRST_TIME_ALERT_ID = "react-project-is_first_time_expand-alert";
            public final static String REMARKS_ALERT_ID = "react-project-remarks-alert";
        }
    }
    public final class BUSINESS_IMPACT{
        public final static String FY_END_DATE_1_ID = "react-project_impact-fy_end_date_0";
        public final static String FY_END_DATE_2_ID = "react-project_impact-fy_end_date_1";
        public final static String FY_END_DATE_3_ID = "react-project_impact-fy_end_date_2";
        public final static String FY_END_DATE_4_ID = "react-project_impact-fy_end_date_3";
        public final static String OVERSEAS_SALES_1_ID = "react-project_impact-overseas_sales_0";
        public final static String OVERSEAS_SALES_2_ID = "react-project_impact-overseas_sales_1";
        public final static String OVERSEAS_SALES_3_ID = "react-project_impact-overseas_sales_2";
        public final static String OVERSEAS_SALES_4_ID = "react-project_impact-overseas_sales_3";
        public final static String OVERSEAS_INVESTMENTS_1_ID = "react-project_impact-overseas_investments_0";
        public final static String OVERSEAS_INVESTMENTS_2_ID = "react-project_impact-overseas_investments_1";
        public final static String OVERSEAS_INVESTMENTS_3_ID = "react-project_impact-overseas_investments_2";
        public final static String OVERSEAS_INVESTMENTS_4_ID = "react-project_impact-overseas_investments_3";
        public final static String RATIONALE_FOR_PROJECTIONS_ID = "react-project_impact-rationale_remarks";
        public final static String NON_TANGIBLE_BENEFITS_ID = "react-project_impact-benefits_remarks";
        public final class ALERT{
            public final static String FY_END_DATE_1_ALERT_ID = "react-project_impact-fy_end_date_0-alert";
            public final static String RATIONALE_FOR_PROJECTIONS_ALERT_ID = "react-project_impact-rationale_remarks-alert";
            public final static String NON_TANGIBLE_BENEFITS_ALERT_ID = "react-project_impact-benefits_remarks-alert";
        }
    }

    public final class COSTS{
        public final class THIRD_PARTY{
            public final static String THIRD_PARTY_HEADER_ID = "react-project_cost-vendors-accordion-header";
            public final static String ADD_THIRD_PARTY_ITEM = "react-project_cost-vendors-add-item";
            public static String IS_VENDOR_SINGAPORE_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-local_vendor-true";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String IS_VENDOR_OVERSEAS_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-local_vendor-false";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String VENDOR_NAME_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-vendor_name";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String VENDOR_SEARCH_BUTTON_ID(int number){
                String temp_id = "react-project_cost-vendors-${number}-vendor_name-vendor";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String VENDOR_UEN_ID(int number){
                String temp_id = "react-project_cost-vendors-${number}-vendor_uen";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String VENDOR_SUPPORTING_DOCUMENTS_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-attachments-input";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String UPLOADED_DOCUMENTS_CSS(int number, int attNumber) {
                String temp_id = "#react-project_cost-vendors-${number}-attachments-${attNumber}-attachment-row > table > tr > td.bgp-attachment-icon > a";
                temp_id =  temp_id.replace("${number}", String.valueOf(number));
                temp_id =  temp_id.replace("${attNumber}", String.valueOf(attNumber));
                return temp_id;
            };
            public static String UPLOADED_DOCUMENTS_ID(int number, int attNumber) {
                String temp_id = "react-project_cost-vendors-${number}-attachments-${attNumberr}-attachment-row";
                temp_id =  temp_id.replace("${number}", String.valueOf(number));
                temp_id =  temp_id.replace("${attNumber}", String.valueOf(attNumber));
                return temp_id;
            };
            public static String UPLOADED_DOCUMENTS_LOADING_MESSAGE_CSS(int number, int attNumber){
                String temp_id = "#react-project_cost-vendors-${number}-attachments-${attNumber}-attachment-row > table > tr > td:nth-child(2) > span";
                temp_id =  temp_id.replace("${number}", String.valueOf(number));
                temp_id =  temp_id.replace("${attNumber}", String.valueOf(attNumber));
                return temp_id;
            }

            public static String ESTIMATE_COST_CURRENCY_ID(int number) {
                String temp_id = "select2-react-project_cost-vendors-${number}-currency_code-container";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String ESTIMATE_COST_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-amount_in_billing_currency";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String EXCHANGE_RATE_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-exchange_rate";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String ESTIMATED_COST_COMPUTED_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-estimated_cost";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public static String REMARKS_ID(int number) {
                String temp_id = "react-project_cost-vendors-${number}-remarks";
                return temp_id.replace("${number}", String.valueOf(number));
            };
            public final class ALERT{
                public static String VENDOR_NAME_ALERT_ID(int number) {
                    String temp_id = "react-project_cost-vendors-${number}-vendor_name-alert";
                    return temp_id.replace("${number}", String.valueOf(number));
                };
                public static String REMARKS_ALERT_ID(int number) {
                    String temp_id = "react-project_cost-vendors-${number}-remarks-alert";
                    return temp_id.replace("${number}", String.valueOf(number));
                };
            }
        }

        public final class OFFICE_SPACE_RENTAL{
            public final static String OFFICE_SPACE_RENTAL_HEADER_ID = "react-project_cost-salaries-accordion-header";
            public final static String ADD_OFFICE_SPACE_ITEM_ID = "react-project_cost-office_rentals-add-item";
            public static String DESCRIPTION_ID(int number){
                String temp_id = "react-project_cost-office_rentals-${number}-description";
                return temp_id.replace("${number}", String.valueOf(number));
            }
            public static String RENTAL_DURATION_ID(int number){
                String temp_id = "react-project_cost-office_rentals-${number}-rental_duration";
                return temp_id.replace("${number}", String.valueOf(number));
            }
            public static String MONTHLY_CURRENCY_ID(int number){
                String temp_id = "select2-react-project_cost-office_rentals-${number}-currency_code-container";
                return temp_id.replace("${number}", String.valueOf(number));
            }
            public static String MONTHLY_RENTAL_AMOUNT_ID(int number){
                String temp_id = "react-project_cost-office_rentals-${number}-amount_in_billing_currency";
                return temp_id.replace("${number}", String.valueOf(number));
            }
            public static String EXCHANGE_RATE_ID(int number){
                String temp_id = "react-project_cost-office_rentals-${number}-exchange_rate";
                return temp_id.replace("${number}", String.valueOf(number));
            }
            public static String MONTHLY_RENTAL_ESTIMATED_COST_ID(int number){
                String temp_id = "react-project_cost-office_rentals-${number}-estimated_cost";
                return temp_id.replace("${number}", String.valueOf(number));
            }

            public static String SUPPORTING_DOCUMENT_INPUT_ID(int number){
                String temp_id = "react-project_cost-office_rentals-${number}-attachments-input";
                return temp_id.replace("${number}", String.valueOf(number));
            }
            public static String UPLOADED_DOCUMENTS_ID(int number, int attNumber) {
                String temp_id = "react-project_cost-office_rentals-${number}-attachments-${attNumber}-attachment-row";
                temp_id =  temp_id.replace("${number}", String.valueOf(number));
                temp_id =  temp_id.replace("${attNumber}", String.valueOf(attNumber));
                return temp_id;
            };
            public final class ALERT{
                public static String DESCRIPTION_ID(int number){
                    String temp_id = "react-project_cost-office_rentals-${number}-description-alert";
                    return temp_id.replace("${number}", String.valueOf(number));
                }
                public static String MONTHLY_RENTAL_AMOUNT_ALERT_ID(int number){
                    String temp_id = "react-project_cost-office_rentals-${number}-amount_in_billing_currency-alert";
                    return temp_id.replace("${number}", String.valueOf(number));
                }
                public static String RENTAL_DURATION_ALERT_ID(int number){
                    String temp_id = "react-project_cost-office_rentals-${number}-rental_duration-alert";
                    return temp_id.replace("${number}", String.valueOf(number));
                }
                public static String REMARKS_ALERT_ID(int number){
                    String temp_id = "react-project_cost-office_rentals-${number}-remarks-alert";
                    return temp_id.replace("${number}", String.valueOf(number));
                }

            }
        }
    }

}

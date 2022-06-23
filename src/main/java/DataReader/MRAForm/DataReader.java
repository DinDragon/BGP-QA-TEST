package DataReader.MRAForm;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import constants.Constants;
import model.*;
import model.MRAForm.BusinessImpactDetail;
import model.MRAForm.ContactDetail;
import model.MRAForm.Cost.CostDetail;
import model.MRAForm.Cost.OfficeSpaceRentalDetail;
import model.MRAForm.Cost.SalaryDetail;
import model.MRAForm.Cost.ThirdPartyCostDetail;
import model.MRAForm.EligibilityDetail;
import model.MRAForm.ProposalDetail;
import util.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class DataReader {
    public static final String dataFolder = "src/main/resources/data/";
    private static Util util = new Util();


    public List<LoginDetail> readLoginDetails(String testNumber) throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.LOGIN_DATA_FILE_NAME));
        CsvToBean<LoginDetail> csvToBean = new CsvToBeanBuilder(reader)
                .withType(LoginDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<LoginDetail> loginDetails = csvToBean.parse();
        return loginDetails;
    }

    public List<EligibilityDetail> readEligibilityDetails(String testNumber) throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.ELIGIBILITY_DETAIL_FILE_NAME));
        CsvToBean<EligibilityDetail> csvToBean = new CsvToBeanBuilder(reader)
                .withType(EligibilityDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<EligibilityDetail> eligibilityDetails = csvToBean.parse();
        return eligibilityDetails;
    }

    public List<ContactDetail> readContactDetails(String testNumber) throws FileNotFoundException{
        Reader reader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.CONTACT_DETAIL_FILE_NAME));
        CsvToBean<ContactDetail> csvToBean = new CsvToBeanBuilder(reader)
                .withType(ContactDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<ContactDetail> contactDetails = csvToBean.parse();
        return contactDetails;
    }

    public List<ProposalDetail> readProposalDetails(String testNumber) throws FileNotFoundException{
        Reader reader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.PROPOSAL_DETAIL_FILE_NAME));
        CsvToBean<ProposalDetail> csvToBean = new CsvToBeanBuilder(reader)
                .withType(ProposalDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<ProposalDetail> proposalDetails = csvToBean.parse();
        return proposalDetails;
    }
    public List<BusinessImpactDetail> readBusinessImpactDetails(String testNumber) throws FileNotFoundException{
        Reader reader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.BUSINESS_IMPACT_FILE_NAME));
        CsvToBean<BusinessImpactDetail> csvToBean = new CsvToBeanBuilder(reader)
                .withType(BusinessImpactDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<BusinessImpactDetail> businessImpactDetails = csvToBean.parse();
        return businessImpactDetails;
    }

    public List<CostDetail> readCostDetails(String testNumber) throws FileNotFoundException{
        Reader reader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.COST_DETAIL_FILE_NAME));
        CsvToBean<CostDetail> csvToBean = new CsvToBeanBuilder(reader)
                .withType(CostDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<CostDetail> costDetails = csvToBean.parse();

        Reader thirdPartyReader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.THIRD_PARTY_COST_DETAIL));
        CsvToBean<ThirdPartyCostDetail> thirdPartyCsvToBean = new CsvToBeanBuilder(thirdPartyReader)
                .withType(ThirdPartyCostDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<ThirdPartyCostDetail> thirdPartyCostDetails = thirdPartyCsvToBean.parse();

        Reader officeSpaceReader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.OFFICE_SPACE_RENTAL_DETAIL));
        CsvToBean<OfficeSpaceRentalDetail> officeSpaceCsvToBean = new CsvToBeanBuilder(officeSpaceReader)
                .withType(OfficeSpaceRentalDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<OfficeSpaceRentalDetail> officeSpaceRentalDetails = officeSpaceCsvToBean.parse();

        Reader salaryDetailReader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + Constants.DATA_FILE_NAME.SALARY_DETAIL_FILE_NAME));
        CsvToBean<SalaryDetail> salaryCsvToBean = new CsvToBeanBuilder(salaryDetailReader)
                .withType(SalaryDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<SalaryDetail> salaryDetails = salaryCsvToBean.parse();

        for(CostDetail costDetail: costDetails){
            costDetail.setThirdPartyCostDetailFromAllList(thirdPartyCostDetails);
            costDetail.setSalaryDetailFromAllList(salaryDetails);
            costDetail.setOfficeSpaceRentalFromAllList(officeSpaceRentalDetails);
        }

        return costDetails;
    }

}

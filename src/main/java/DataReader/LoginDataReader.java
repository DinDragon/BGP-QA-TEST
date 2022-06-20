package DataReader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.LoginDetail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class LoginDataReader {
    public static final String dataFolder = "src/main/resources/data/";
    public static final String fileName = "loginData.csv";

    public List<LoginDetail> readLoginDetails(String testNumber, String fileName) throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader(dataFolder + "/" + testNumber + "/" + fileName));
        CsvToBean<LoginDetail> csvToBean = new CsvToBeanBuilder(reader)
                .withType(LoginDetail.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<LoginDetail> loginDetails = csvToBean.parse();
        return loginDetails;
    }
}

package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertyReader {

    private String propertiesFileLocation = "src/main/resources/Properties/config.properties";
    public String CHROME_BINARY_LOCATION = "chromeBinaryLocation";
    public String CHROME_WEBDRIVER_LOCATION = "chromeWebDriverLocation";
    public String BASE_URL = "baseUrl";

    public PropertyReader() {
    }

    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFileLocation)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
            // get the property value and print it out
            return properties;

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFileLocation)) {

            properties = new Properties();

            // load a properties file
            properties.load(input);
            System.out.println(properties.size());
            // get the property value and print it out

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return properties.getProperty(key);
    }
}

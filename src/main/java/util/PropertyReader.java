package util;

import constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public final class PropertyReader {

    public PropertyReader() {
    }

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(Constants.PROPERTY_VARIABLE.PROPERTY_FILE_LOCATION)) {

            properties = new Properties();

            // load a properties file
            properties.load(new InputStreamReader(input, Charset.forName("UTF-8")));
            // get the property value and print it out
            return properties;

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(Constants.PROPERTY_VARIABLE.PROPERTY_FILE_LOCATION)) {

            properties = new Properties();

            // load a properties file
            properties.load(input);
            System.out.println(properties.size());
            // get the property value and print it out


        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
//        if(key.equals(Constants.PROPERTY_VARIABLE.SERVER_LOGIN_PASSWORD)){
//            return AES.decrypt(properties.getProperty(key), Constants.SECRET_KEY);
//        }else {
            return properties.getProperty(key);
//        }
    }
}

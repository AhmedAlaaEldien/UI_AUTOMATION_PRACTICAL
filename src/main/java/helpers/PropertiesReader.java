package helpers;

import utilities.PropertiesManager;

import java.util.Properties;


/**
 * This class is used to read the data from properties file.
 */
public class PropertiesReader {
    private static final String propRoot = "src/main/resources/";
    private final Properties prop;

    public PropertiesReader(String fileName) {
        prop = PropertiesManager.loadPropertyFile(propRoot + fileName);
    }

    public String getProperty(String propName) {
        return prop.getProperty(propName);
    }
}

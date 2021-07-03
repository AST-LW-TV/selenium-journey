package selenium_scripts.e_commerce_automation.Utilities;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties prop = new Properties();
    private static FileInputStream file;

    // static initializer - runs once when the class is called ... 
    static {
        try {
            file = new FileInputStream("./src/main/java/selenium_scripts/e_commerce_automation/Utilities/config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            System.exit(-1); // unsuccessful termination
        }
    }

    // searches the value from the properties file
    public static String getValue(String key) {
        try {
            prop.load(file);
        } catch (IOException e) {
            System.out.println("File Error...");
            System.exit(-1);
        }
        return prop.getProperty(key);
    }

    // this method is used in test case for configuring different conditions...
    public static void setValue(String key,String value){
        try {
            String path="./src/main/java/selenium_scripts/e_commerce_automation/Utilities/config.properties";
            PropertiesConfiguration propertiesFile=new PropertiesConfiguration(path);
            FileOutputStream file=new FileOutputStream(path);
            propertiesFile.setProperty(key,value);
            propertiesFile.save(file);
        } catch (ConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

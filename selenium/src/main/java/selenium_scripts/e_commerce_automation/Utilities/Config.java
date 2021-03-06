package selenium_scripts.e_commerce_automation.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    /**
     * this method gets the key from the properties file
     * @param key
     * @return value
     */
    public static String getValue(String key) {
        try {
            prop.load(file);
        } catch (IOException e) {
            System.out.println("File Error...");
            System.exit(-1);
        }
        return prop.getProperty(key);
    }
}

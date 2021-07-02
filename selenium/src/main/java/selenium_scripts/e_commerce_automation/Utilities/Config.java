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

    public static String getValue(String key) throws IOException {
        prop.load(file);
        return prop.getProperty(key);
    }
}

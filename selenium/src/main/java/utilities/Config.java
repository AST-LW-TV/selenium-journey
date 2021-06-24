package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties globalConfig = new Properties();
    private static FileInputStream file;

    static {
        try {
            file = new FileInputStream("./src/main/java/utilities/config.properties");
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }

    public static String getValue(String key) throws IOException {
        globalConfig.load(file);
        return globalConfig.getProperty(key);
    }

}

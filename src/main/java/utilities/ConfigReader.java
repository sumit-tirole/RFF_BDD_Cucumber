package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public String readFromPropertyFile(String key) throws IOException
    {
        String osName = System.getProperty("os.name");
        FileInputStream fis;

        if (osName.contains("Windows")) {
            fis = new FileInputStream(".\\src\\test\\resources\\Config\\config.properties");
        } else {
            fis = new FileInputStream("./src/test/resources/Config/config.properties");
        }

        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        return value;
    }

}

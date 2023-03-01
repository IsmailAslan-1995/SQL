package utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    private static Properties prop;

    static{
        String path = "config.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            prop = new Properties();
            prop.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Path: " + path + " - not found.");
        }
    }
    public static String getProperty(String key){
        return prop.getProperty(key);
    }

}
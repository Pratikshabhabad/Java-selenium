package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    
    private static Properties properties;

    public static void loadProperties()
    {
        //System.out.println("Loading properties file..");

        properties=new Properties();

        try {

            FileInputStream file=new FileInputStream("src/test/resources/config/config.properties");
            properties.load(file);
            //System.out.println("Properties load successfully..");
            
        } 
        catch (Exception e) {
            throw new RuntimeException("Failed to load Config.properties",e);

        }
    }

    public static String getProperty(String key)
    {
        String value=properties.getProperty(key);
        if(value==null || value.trim().isEmpty())
        {
            throw new RuntimeException("Missing or Empty Configuration Property"+key);

        }

        return value.trim();
    }
}

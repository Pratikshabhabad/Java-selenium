package testData;

import utils.ConfigReader;

public class LoginTestData {
    public static String getEmail()
    {
        return ConfigReader.getProperty("login.email");

    }

    public static String getPassword()
    {
        return ConfigReader.getProperty("login.password");
    }

    public static String getInvalidEmail()
    {
        return ConfigReader.getProperty("invalid.login.email");
    }

    public static String getInvalidPassword()
    {
        return ConfigReader.getProperty("invalid.login.password");
    }
}

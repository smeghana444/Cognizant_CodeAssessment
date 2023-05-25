package com.usga.qa.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class propertiesclass
{


    public static String initializeproperties(String propertyName)
    {

            String configpath = System.getProperty("user.dir")+"/src/main/java/com/usga/qa/config/config.properties";
  
        try {
            InputStream instm = new FileInputStream(configpath);
            Properties prop = new Properties();
            prop.load(instm);
            configpath = prop.getProperty(propertyName);

        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return configpath;
    }
}
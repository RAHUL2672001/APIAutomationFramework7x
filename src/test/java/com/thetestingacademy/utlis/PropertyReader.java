package com.thetestingacademy.utlis;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    //Responsibility if the class is to give the value by key

    public static String readKey(String key){
        Properties properties = new Properties();
        //Legacy 1.2jdk,-old
        try {
            //Read the data .properties and give the key ->value
            FileInputStream fileInputStream = new FileInputStream("src/test/java/com/thetestingacademy/Resources/data.properties");
            properties.load(fileInputStream);
        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
        return properties.getProperty(key);
    }
}

package test.day9_testbase_properties_driverUtil;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_properties_file() throws IOException {
        //Properties class object allows us to read from configuration.properties
        Properties properties = new Properties();

        //We need to show where the file is stored.
        //We need the pass of the file.
        String path = "configuration.properties";
        //C:\Users\Nurida\Desktop\seleniumproject\configuration.properties

        //We need to open this configuration.properties file in java memory
        FileInputStream file = new FileInputStream(path);

        //We need to load the opened file into the properties object
        properties.load(file);

        //we can read the configuration.properties file using properties object
        //properties.getProperty("browser").soutv;
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));
    }



}

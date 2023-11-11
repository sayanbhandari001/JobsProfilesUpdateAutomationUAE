package org.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    protected Properties configProp;

    //this is to read files from Config.properties Files
    public Properties init_prop() {
        //Load properties File
        configProp = new Properties();
        try {
            FileInputStream configPropfile = new FileInputStream("config.properties");
            configProp.load(configPropfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProp;
    }
}

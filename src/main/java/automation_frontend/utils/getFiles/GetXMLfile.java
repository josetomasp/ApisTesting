package automation_frontend.utils.getFiles;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetXMLfile {

    public static String getConfProperties(String propertyConf) throws IOException {

        String property = null;
        Properties prop = new Properties();

        prop.loadFromXML(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/conf/config.xml"));
        property = prop.getProperty(propertyConf);

        return property;
    }
}
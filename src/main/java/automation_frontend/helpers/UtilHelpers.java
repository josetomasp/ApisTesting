package automation_frontend.helpers;

import automation_frontend.utils.getFiles.GetXMLfile;
import org.openqa.selenium.By;
import io.appium.java_client.MobileDriver;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UtilHelpers {

    public boolean displayed(MobileDriver driver, By element) {

        boolean value = false;
        try {

            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            value = driver.findElements(element).size() != 0;
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(GetXMLfile.getConfProperties("IMPLICIT_WAIT")), TimeUnit.SECONDS);

        } catch (Exception e) {
            value = false;
        }
        return value;
    }


}

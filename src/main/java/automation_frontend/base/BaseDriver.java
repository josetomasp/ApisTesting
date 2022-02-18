package automation_frontend.base;

import automation_frontend.utils.enums.EGlobalVars;
import automation_frontend.utils.vars.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseDriver {

    private static ThreadLocal<WebDriver> cDrivers = new ThreadLocal<>();
    private static List<WebDriver> cStoreDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
                                                 public void run() {

                                                     cStoreDrivers.stream().forEach(WebDriver::quit);
                                                 }
                                             }
        );

    }

    public static void addDriver(WebDriver driver) {
        cStoreDrivers.add(driver);
        cDrivers.set(driver);
    }

    public static WebDriver getDriver() {

        return cDrivers.get();
    }

    public static void removeDriver() {

        cStoreDrivers.remove(cDrivers.get());
    }




}

package automation_frontend.steps;

import automation_frontend.base.BaseDriver;
import automation_frontend.utils.enums.EGlobalVars;
import automation_frontend.utils.getFiles.GetXMLfile;
import automation_frontend.utils.vars.GlobalVars;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public WebDriver cDriver = null;


    @Before
    public void setUp() throws Exception {

        String mode = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("mode");
        String os = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os");
        GlobalVars.setVar(EGlobalVars.SYSTEM_OPERATION, os);
        String url = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("url");

        switch (mode.toUpperCase()){
            case "LOCAL":

                if(os.equalsIgnoreCase("CHROME")) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                    cDriver = new ChromeDriver();
                }
                break;
            case "REMOTE":
            case "API":

                break;
        }
        if(os.equalsIgnoreCase("CHROME")){
            cDriver.manage().timeouts().implicitlyWait(Integer.parseInt(GetXMLfile.getConfProperties("IMPLICIT_WAIT")), TimeUnit.SECONDS);
            BaseDriver.addDriver(cDriver);
            cDriver.manage().window().maximize();
            cDriver.get(url);
        }
    }

    /*@After
    public void after() {
        BaseDriver.getDriver().quit();
        BaseDriver.removeDriver();
        }*/
}

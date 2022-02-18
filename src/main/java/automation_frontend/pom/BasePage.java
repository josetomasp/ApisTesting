package automation_frontend.pom;

import automation_frontend.helpers.Clickable;
import automation_frontend.helpers.Inputable;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage implements Clickable, Inputable {

    protected WebDriver driver = null;
    protected WebDriverWait waiter = null;

    @Override
    public WebDriver getDriver() { return this.driver; }

    @Override
    public WebDriverWait waiter() { return this.waiter; }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }


}

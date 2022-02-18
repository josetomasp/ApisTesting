package automation_frontend.helpers;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public interface Clickable extends Waitable {

    //Click for element
    default void click(By element){
        try {
            waitForVisible(element);
            waitForClickable(element);
            getDriver().findElement(element).click();
        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Click for element
    default void click(WebElement element){
        try {
            waitForVisible(element);
            element.click();
        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Click for element
    default void click(By element, By BySpinner){
        try {
            waitForVisible(element);
            waitForClickable(element);
            getDriver().findElement(element).click();
            waitForInvisible(BySpinner);
        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }
}

package automation_frontend.helpers;

import org.openqa.selenium.By;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public interface Inputable extends Waitable {

    default void sendKey(By element, String value){

        try {
            waitForVisible(element);
            getDriver().findElement(element).sendKeys(value);
        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    default void sendKey(WebElement element, String value){
        try {
            waitForVisible(element);
            element.sendKeys(value);
        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    default void sendKey(WebElement element, String value, WebElement waitForElement){
        try {
            waitForVisible(element);
            element.sendKeys(value);
        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }
    default void exist(WebElement element){
        try {
            waitForVisible(element);
            element.getSize();
        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }
}

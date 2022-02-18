package automation_frontend.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public interface Waitable extends Driverable {

    WebDriverWait waiter();

    //Wait for Element Clickable
    default void waitForClickable(By element){
        try {
            waiter().until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Wait for Element Clickable
    default void waitForClickable(WebElement element){
            try {
                waiter().until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e){
                Assert.fail(e.getMessage(),e);
                new Exception(e);
            }
    }

    //Wait for Element Clickable
    default void waitForVisible(By element){
        try {
            waiter().until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Wait for Element Visible
    default void waitForVisible(WebElement element){
        try {
            waiter().until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Wait for Element invisible
    default void waitForInvisible(By element) {
        try {
            waiter().until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }

       /* try {

            WebDriverWait wait = new WebDriverWait(driver, 20, 500);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.WARNING, e.toString());
            Assert.fail();
            new Exception(e);
        }*/
    }

    //Wait for Element invisible
    default void waitForInvisible(WebElement element) {
        try {
            waiter().until(ExpectedConditions.invisibilityOf(element));

        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }

       /* try {

            WebDriverWait wait = new WebDriverWait(driver, 20, 500);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.WARNING, e.toString());
            Assert.fail();
            new Exception(e);
        }*/
    }

    //Wait for text on element
    default void waitForTextToBePresentInElement(WebElement element, String text) {
        try {
            waiter().until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }

       /* try {

            WebDriverWait wait = new WebDriverWait(driver, 20, 500);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.WARNING, e.toString());
            Assert.fail();
            new Exception(e);
        }*/
    }

}

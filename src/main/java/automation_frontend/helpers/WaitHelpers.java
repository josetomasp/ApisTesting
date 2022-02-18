package automation_frontend.helpers;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WaitHelpers {

    //Wait for Element Clickable
    public void clickable(WebDriver driver, By element){

        try {

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));

        }catch (Exception e){
            Assert.fail();
            new Exception(e);
        }
    }

    //Wait for Element Clickable
    public void clickable(WebDriver driver, WebElement element){

        try {

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));

        }catch (Exception e){
            Assert.fail();
            new Exception(e);
        }
    }

    //Wait for Element Clickable
    public void visible(WebDriver driver, By element){

        try {

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Wait for Element Visible
    public void visible(WebDriver driver, WebElement element){

        try {

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(element));

        }catch (Exception e){
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Wait for Element invisible
    public void invisible(WebDriver driver, By element) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

            } catch (NoSuchElementException e) {
                Assert.fail(e.getMessage(),e);
                new Exception(e);
            }
    }

    //Wait for Element invisible
    public void invisible(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.invisibilityOf(element));

        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Wait for text on element
    public void textToBePresentInElement(WebDriver driver, WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));

        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }
    }




package automation_frontend.helpers;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;


public class AssertsHelpers {

    static WaitHelpers waitHelpers = new WaitHelpers();

    //Assert Equals
    public static void equals(String value1, String value2) {
        try {
            Assert.assertEquals(value1, value2);
        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }


    public static void equals(MobileDriver driver, MobileElement element, String value2, int index, String splitBy) {

        try {
            waitHelpers.visible(driver, element);
            String[] value = element.getText().split(splitBy);

            Assert.assertEquals(value[index], value2);

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert Equals
    public static void equals(MobileDriver driver, By element, String value2) {

        try {

            waitHelpers.visible(driver, element);
            String value = driver.findElement(element).getText();

            Assert.assertEquals(value, value2);

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert Equals
    public static void equals(MobileDriver driver, MobileElement element, String value2) {

        try {

            waitHelpers.visible(driver, element);
            String value = element.getText();

            if(value.equals(""))
                value = element.getAttribute("value");

            Assert.assertEquals(value, value2);

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert Contains
    public static void contains(MobileDriver driver, By element, String value2) {

        try {

            waitHelpers.visible(driver, element);
            String value = driver.findElement(element).getText();

            Boolean flag = value.contains(value2);
            Assert.assertTrue(flag);

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert Contains
    public static void contains(MobileDriver driver, MobileElement element, String value2) {

        try {

            waitHelpers.visible(driver, element);
            String value = element.getText();

            Boolean flag = value2.contains(value);
            Assert.assertTrue(flag);

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert Exist
    public static void exist(MobileDriver driver, By element) {

        try {

            waitHelpers.visible(driver, element);

            boolean value = driver.findElement(element).isDisplayed();
            Assert.assertTrue(value);

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert Exist
    public static void exist(MobileDriver driver, MobileElement element) {

        try {

            waitHelpers.visible(driver, element);

            boolean value = element.isDisplayed();
            Assert.assertTrue(value);

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert no Exist
    public static void noExist(MobileDriver driver, By element) {

        try {
            waitHelpers.invisible(driver, element);

            driver.findElement(element);
            Assert.assertTrue(false);

        } catch (org.openqa.selenium.NoSuchElementException e) {

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }

    //Assert no Exist
    public static void noExist(MobileDriver driver, MobileElement element) {

        try {
            waitHelpers.invisible(driver, element);

            boolean ele = element.isDisplayed();
            Assert.assertTrue(!ele);

        } catch (org.openqa.selenium.NoSuchElementException e) {

        } catch (Exception e) {
            Assert.fail(e.getMessage(),e);
            new Exception(e);
        }
    }
}

package automation_frontend.steps;

import automation_frontend.base.BaseDriver;
import automation_frontend.helpers.WaitHelpers;
import automation_frontend.utils.operations.MathematicalOperations;
import org.openqa.selenium.WebDriver;


public class BaseSteps {

    public MathematicalOperations mathOperations = new MathematicalOperations();
    public WebDriver driver = BaseDriver.getDriver();
    public WaitHelpers waitHelpers = new WaitHelpers();
}

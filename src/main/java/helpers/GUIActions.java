package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static helpers.AssertionType.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class GUIActions {
    private final WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;


    public GUIActions(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 200);
    }

    /**
     * This function is used to do the clickOn action on any selected element
     * by passing the target element to it and wait till this element is presence and clickable
     * then do the click action
     */
    public void clickOn(By by)  {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This function is used to get text from any element is passed to it.
     * by passing the target element to it and wait till this element is presence and get its text
     * @return this text
     */
    public String getTextFromElement(By by){
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    @Deprecated
    public void assertThat(AssertionType assertType, Object actual, Object expected, String msg){
        if(assertType==TRUE)
            assertTrue((boolean) expected);
        if(assertType==FALSE)
            assertFalse((boolean) expected);
        if(assertType==EQUALS)
            assertEquals(expected, actual);
        if(assertType==NOT_EQUALS)
            assertNotEquals(expected, actual);

    }

    public void assertThat(String msg, Runnable assertion){assertion.run();}
}


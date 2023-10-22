package functions;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFunctions extends TestBase {

    public PageFunctions() {
    }

    public static void waitAndClickOnElement(By xpath) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(xpath));
        element.click();
    }
    public static Boolean elementIsDisplayed(By xpath) {
        int i = 0;
        Boolean isDisplayed = true;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        } catch (org.openqa.selenium.TimeoutException e) {
            isDisplayed = false;
        }

        return isDisplayed;
    }
    public static void sendKeys(By xpath, String keys) {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(xpath));
        element.sendKeys(keys);
    }
    public static void sendKeys(By xpath, Keys key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(xpath));
        element.sendKeys(key);
    }
}

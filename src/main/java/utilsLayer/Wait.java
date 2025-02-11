package utilsLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import BaseLayer.BaseClass;

public class Wait extends BaseClass {

    public static void click(WebElement wb) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(wb)).click();
    }

    public static void submit(WebElement wb) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(wb)).submit();
    }

    public static WebElement visiblityOf(WebElement wb) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(wb));
    }

    public static void sendKeys(WebElement wb, String value) {
        visiblityOf(wb).sendKeys(value);
    }

    public static String getText(WebElement wb) {
        return visiblityOf(wb).getText();
    }

    public static String getAttribute(WebElement wb, String value) {
        return visiblityOf(wb).getAttribute(value);
    }

    public static void clear(WebElement wb) {
        visiblityOf(wb).clear();
    }

    public static boolean isDisplayed(WebElement wb) {
        return visiblityOf(wb).isDisplayed();
    }

    public static boolean isEnabled(WebElement wb) {
        return visiblityOf(wb).isEnabled();
    }

    public static boolean isSelected(WebElement wb) {
        return visiblityOf(wb).isSelected();
    }
}

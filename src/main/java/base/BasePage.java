package base;

import constants.ConstantTimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriverWait getWait(WebDriver driver, long timeOut) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    public WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator, long timeOut) {
        return getWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator) {
        return waitForVisibilityOfElementLocated(driver, locator, ConstantTimeOut.DEFAULT_TIMEOUT);
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, By locator, long timeOut) {
        return getWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElementToBeClickable(driver, locator, ConstantTimeOut.DEFAULT_TIMEOUT);
    }

    public void waitForInvisibilityOfElementLocated(WebDriver driver, By locator, long timeOut) {
        getWait(driver, timeOut).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForInvisibilityOfElementLocated(WebDriver driver, By locator) {
        waitForInvisibilityOfElementLocated(driver, locator, ConstantTimeOut.DEFAULT_TIMEOUT);
    }

    public void sendKeys(WebDriver driver, By locator, String value, long timeOut) {
        WebElement element = waitForVisibilityOfElementLocated(driver, locator, timeOut);
        element.sendKeys(value);
    }

    public void sendKeys(WebDriver driver, By locator, String value) {
        sendKeys(driver, locator, value, ConstantTimeOut.DEFAULT_TIMEOUT);
    }

    public void click(WebDriver driver, By locator, long timeOut) {
        WebElement element = waitForElementToBeClickable(driver, locator, timeOut);
        element.click();
    }

    public void click(WebDriver driver, By locator) {
        click(driver, locator, ConstantTimeOut.DEFAULT_TIMEOUT);
    }

    public String getText(WebDriver driver, By locator, long timeOut) {
        WebElement element = waitForVisibilityOfElementLocated(driver, locator, timeOut);
        return element.getText();
    }

    public String getText(WebDriver driver, By locator) {
        return getText(driver, locator, ConstantTimeOut.DEFAULT_TIMEOUT);
    }
}

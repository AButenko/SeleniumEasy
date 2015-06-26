package org.qacamp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Admin on 6/24/2015.
 */
class BasePage {

    private static final long defaultExplicitlyWaitTimeout = 15;

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //In this class create "quick tools" for child classes and some methods which can be called on all web- pages:

    //xpath-selector (locator) is one of the best:

    protected WebElement findElementByXpath(String elementXpath) {
        return driver.findElement(By.xpath(elementXpath));
    }

    //universal tool to find element:

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    //finds all element, which match elementXpath locator:

    protected List<WebElement> findAllElementsByXpath(String elementXpath) {
        return driver.findElements(By.xpath(elementXpath));
    }

    //the same method for any locator type:

    protected List<WebElement> findAllElements(By locator) {
        return driver.findElements(locator);
    }

    //very good method to wait before browser render some elements and make them enabled on the page (protected from errors):

    protected WebElement waitUntilElementToBeClickable(String elementXpath) {
        return new WebDriverWait(driver, defaultExplicitlyWaitTimeout)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

    //the same method for any locator type, using "overloading" (the same name but parameters differ):

    protected WebElement waitUntilElementToBeClickable(By locator) {
        return new WebDriverWait(driver, defaultExplicitlyWaitTimeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitUntilElementToBeVisible(By locator) {
        return new WebDriverWait(driver, defaultExplicitlyWaitTimeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickOnFirstVisibleElement(List<WebElement> elements) {
        int size = elements.size(),
            i = 0;
        for (WebElement e; i < size; i++) {
            e = elements.get(i);
            if (e.isDisplayed() && e.isEnabled()) {
                e.click();
            }
        }
    }

    protected WebElement activeElement() {
        return driver.switchTo().activeElement();
    }
}

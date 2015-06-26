package org.qacamp.tests.initial;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Admin on 6/24/2015.
 */
public class InitialTestClass {

    //"@Test" - annotation (parameter). It is supported by TestNG framework, wraps methods like calling in "main"

    @Test
    public void webdriverIntroduction() {

        //create object of FirefoxDriver (load Firefox):

        WebDriver driver = new FirefoxDriver();

        //set maximum size of browser window:

        driver.manage().window().maximize();

        //call method "get" from driver object, which get url of some resource and redirect to it:

        driver.get("http://translate.google.com/");

        //find web element by name selector and type text:

        driver.findElement(By.name("text")).sendKeys("Hello, World!");
    }

    //@Test //uncomment "@Test", which you want run and comment other "@Test"
    public void engToFrenchCheeseTranslation() {

        //open start page:

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://translate.google.com/");

        //find all elements, which match next selector and put them into list:

        List<WebElement> langPanels = driver.findElements(By.xpath("//*[@id='gt-langs']/*"));

        //left get first element in list (it will be left), find new and click on it:

        langPanels.get(0).findElement(By.id("gt-sl-gms")).click();

        driver.findElement(By.xpath("//*[text()='English' and not(contains(@class, 'jfk-button'))]")).click();

        //set language for right side:

        langPanels.get(1).findElement(By.id("gt-tl-gms")).click();
        List<WebElement> frenchLangList;
        frenchLangList = driver.findElements(By.xpath("//*[text()='French' and not(contains(@class, 'jfk-button'))]"));

        //find visible element and click on it:

        for (WebElement elm : frenchLangList) {
            if (elm.isDisplayed()) elm.click();
        }

        driver.findElement(By.name("text")).sendKeys("Cheese");

        //wait until next element to be visible on the page:

        WebElement resultBoxElement = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("hps")));

        String expectedResult = "fromage";
        String actualResult = resultBoxElement.getText().toLowerCase();

        //verify than actual result match to expected (provided by TestNG framework):

        Assert.assertEquals(expectedResult, actualResult);
    }
}

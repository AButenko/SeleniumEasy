package org.qacamp.tests.advanced;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qacamp.pages.PGoogleTranslate;
import org.qacamp.utils.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Admin on 6/25/2015.
 */
public class GoogleTranslation {

    //define "Webdriver" object with "driver" name:

    private WebDriver driver;

    //"beforeClass" will be running before all test-methods:

    @BeforeClass
    public void beforeClass() {

        //initialize driver object calling method "setup", which get new "FirefoxDriver" (object) as parameter:

        driver = Browser.setup(new FirefoxDriver());
    }

    //here "driver" obj is initialized and can be used for manipulating with "Firefox" browser in all next methods below:

    //"afterClass" close browser after all test-methods:

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void engToFrenchCheeseTranslate() {
        PGoogleTranslate pGoogleTranslate = new PGoogleTranslate(driver);
        String wordToTranslate = "Cheese",
                expectedResult = "fromage";

        pGoogleTranslate.setLanguages("English", "French");
        String actualResult = pGoogleTranslate.translateWord(wordToTranslate);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(priority = 1)
    public void engToSpanishCheeseTranslate() {
        PGoogleTranslate pGoogleTranslate = new PGoogleTranslate(driver);
        String wordToTranslate = "Cheese",
                expectedResult = "queso";

        pGoogleTranslate.setLanguages("English", "Spanish");
        String actualResult = pGoogleTranslate.translateWord(wordToTranslate);

        Assert.assertEquals(expectedResult, actualResult);
    }
}

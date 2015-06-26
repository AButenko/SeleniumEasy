package org.qacamp.utils;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 6/25/2015.
 */
public class Browser {

    private static final int defaultPageLoadTimeout = 45;
    private static final int defaultScriptLoadTimeout = 30;
    private static final int defaultImplicitlyWaitTimeout = 3;

    private static final String startPageUrl = "http://translate.google.com/";

    //get FirefoxDriver, ChromeDriver or other object, set preferences and return it:

    public static WebDriver setup(WebDriver driver) {

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(defaultPageLoadTimeout, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(defaultScriptLoadTimeout, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(defaultImplicitlyWaitTimeout, TimeUnit.SECONDS);

        //also we can make next page as start-page for browser:

        driver.get(startPageUrl);

        return driver;
    }
}

package org.qacamp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Admin on 6/25/2015.
 */
public class PGoogleTranslate extends BasePage {

    public PGoogleTranslate(WebDriver driver) {
        super(driver);
    }

    public void setLanguages(String inputBoxLanguage, String resultBoxLanguage) {

        //set language for left side:

        List<WebElement> langPanels = findAllElementsByXpath("//*[@id='gt-langs']/*");
        langPanels.get(0).findElement(By.id("gt-sl-gms")).click();
        findElementByXpath("//*[text()='"+inputBoxLanguage+"' and not(contains(@class, 'jfk-button'))]").click();

        //set language for right side:

        langPanels.get(1).findElement(By.id("gt-tl-gms")).click();
        List<WebElement> resultLangList;
        resultLangList = findAllElementsByXpath("//*[text()='"+resultBoxLanguage+"' and not(contains(@class, 'jfk-button'))]");
        getFirstVisibleElement(resultLangList).click();
    }

    //returns actual result:

    public String translateWord(String word) {
        findElement(By.name("text")).clear();
        activeElement().sendKeys(word);
        WebElement resultBoxElement = waitUntilElementToBeVisible(By.className("hps"));
        return resultBoxElement.getText().toLowerCase();
    }
}

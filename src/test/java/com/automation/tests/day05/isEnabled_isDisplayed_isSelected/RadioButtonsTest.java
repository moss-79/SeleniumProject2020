package com.automation.tests.day05.isEnabled_isDisplayed_isSelected;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        //<input type="radio" id="green" name="color" disabled="">
        WebElement blackButton = driver.findElement(By.id("black"));

        //if visible and eligible to click
        if (blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println(" click on black button");
            blackButton.click();
        }
        else{
            System.out.println("FAILED to click on black button");
        }

        //how to verify that button clicked
        if (blackButton.isSelected()) System.out.println("TEST PASSED"      );
        else System.out.println("TEST FAILED");

        BrowserUtils.wait(2);


        driver.quit();
    }
}

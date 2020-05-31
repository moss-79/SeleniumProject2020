package com.automation.tests.isEnabled_isDisplayed_isSelected;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

    //    checkBoxes.get(0).click(); // click on the first checkbox

        BrowserUtils.wait(2);
        for (int i = 0; i < checkBoxes.size(); i++) {


//                              if visible,                        eligible to click                 not clicked yet
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && !checkBoxes.get(i).isSelected()) {
                // if checkbox is not selected, don't click
                checkBoxes.get(i).click(); // click on the second checkbox
                System.out.println(i+1 +" checkbox is clicked");
            }else {
                System.out.println("checkbox "+ (i+1) +" wasn't clicked! // because it was already selected");
            }
            BrowserUtils.wait(2);

        }
        driver.quit();
    }
}

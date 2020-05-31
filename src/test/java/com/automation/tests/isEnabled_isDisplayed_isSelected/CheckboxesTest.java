package com.automation.tests.isEnabled_isDisplayed_isSelected;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxesTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        // #TASK
        //verify that 1st checkbox is not selected and 2nd is selected
        List<WebElement > checkboxes = driver.findElements(By.tagName("input"));

        if (!checkboxes.get(0).isSelected() && checkboxes.get(1).isSelected()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");

        }
        BrowserUtils.wait(2);

        WebElement checkbox1 = checkboxes.get(0);
        checkbox1.click();

        if (checkbox1.isSelected()){
            System.out.println("TEST PASSED"        );
            System.out.println("checkbox #1 is selected");

        }else {
            System.out.println("TEST FAILED");
            System.out.println("checkbox #1 is not selected");
        }

        driver.quit();
    }
}

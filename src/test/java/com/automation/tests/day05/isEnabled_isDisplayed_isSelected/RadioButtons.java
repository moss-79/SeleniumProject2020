package com.automation.tests.day05.isEnabled_isDisplayed_isSelected;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton :
                radioButtons) {
            String id = radioButton.getAttribute("id");

            boolean isSelected = radioButton.isSelected();
            System.out.println(id +" is selected? "+ isSelected);


            if (radioButton.isEnabled()) {

                radioButton.click();
                System.out.println("Clicked on : " + id);
                BrowserUtils.wait(1);

            }else{
                System.out.println(id + " : is Disabled, not clickable" );
            }
            System.out.println();
        }




        driver.quit();
    }
}

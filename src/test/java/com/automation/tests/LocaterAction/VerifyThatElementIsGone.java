package com.automation.tests.LocaterAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.id("disappearing_button")).size() == 0){
            System.out.println( "TEST PASSED");
        }else {
            System.out.println(" TEST FAILED");
        }

        Thread.sleep(2000);

        // to find all buttons
        // make sure tat you use findElements ---> ending is important
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement button :
                buttons) {
            button.click();
            Thread.sleep(2000);

        }

        driver.quit();

    }
}

package com.automation.tests.day05.frames;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(3);


        driver.switchTo().frame("frame-top").getTitle();
        driver.switchTo().frame("frame-middle").getTitle();
//
//
        WebElement content = driver.findElement(By.id("content"));
        System.out.println(content.getText());

        driver.switchTo().parentFrame();// to go back to top frame from middle
        driver.switchTo().frame("frame-right"); // now from top to switch to the right frame

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText()   )   ;

        // to go to the bottom frame you have to go to default content
        // because, top frame is a sibling for bottom frame, but not a parent

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        System.out.println(driver.findElement(By.tagName("body")).getText());





        driver.quit();
    }
}

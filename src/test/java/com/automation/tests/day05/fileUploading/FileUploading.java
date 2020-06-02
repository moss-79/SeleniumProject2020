package com.automation.tests.day05.fileUploading;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);

        WebElement upload = driver.findElement(By.id("file-upload"));

//        https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html // where i get the property
        String filePath = System.getProperty("user.dir")+"/pom.xml";// I am uploading pom.xml
        String filePath2 = "C:/Users/MOSSF/Pictures/image(2).png" ;// I uploaded this from my photo

        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(2);


        driver.quit();
    }
}

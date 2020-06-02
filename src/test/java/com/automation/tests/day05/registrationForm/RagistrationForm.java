package com.automation.tests.day05.registrationForm;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RagistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(3);

        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("Jhon");
        driver.findElement(By.name("lastname")).sendKeys("Snow");
        driver.findElement(By.name("username")).sendKeys("KingInTheNorth");
        driver.findElement(By.name("email")).sendKeys("jhonsnow@email.com");
        driver.findElement(By.name("password")).sendKeys("BastardOfStark27");
        driver.findElement(By.name("phone")).sendKeys("574-456-2134");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        // select gender
        genders.get(1).click();// selected male

        driver.findElement(By.name("birthday")).sendKeys("06/12/1911");

        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);



        driver.quit();

    }
}

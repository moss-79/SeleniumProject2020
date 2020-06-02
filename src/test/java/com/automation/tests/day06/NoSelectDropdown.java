package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click(); // to expand dropdown
        BrowserUtils.wait(2);

      //  <a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        driver.findElement(By.linkText("Amazon")).click();// click on option
        driver.navigate().back();

        // to get all the links you go back and do it like from the first
        driver.findElement(By.id("dropdownMenuLink")).click(); // to expand dropdown
        BrowserUtils.wait(2);
        List<WebElement> links = driver.findElements(By.className("dropdown-item"));
        for (WebElement link : links){
         //   link.click();
            System.out.println(link.getText()+ " : "  +link.getAttribute("href"));
            BrowserUtils.wait(2);
          //  driver.navigate().back();
           // System.out.println();
        }




        BrowserUtils.wait(3 );
        driver.quit();
    }
}

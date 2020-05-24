package com.automation.tests.LocaterAction;

import com.google.gson.JsonArray;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp_ {
  // static WebDriver driver;

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();


      //  ebbay();
      //  amazon();
        wikipedia();



    }
    //Go to ebay
    //enter search term
    //click on search button
    //print number of results

    public static void ebbay(){
        WebDriver driver = new ChromeDriver() ;

        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")   ).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]  );
        driver.quit();
    }

    //go to amazon

    //enter search term
    //click on search button
    //verify title contains search term
    public static void amazon(){
        WebDriver driver = new ChromeDriver() ;

        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

     String title = driver.getTitle();
     if (title.contains("java book")){
         System.out.println("TEST PASSED");
     }else {
         System.out.println("TEST FAILED");
     }
        driver.quit();

    }

    //Go to wikipedia.org
    //enter search term `selenium webdriver`
    //click on search button
    //click on search result `Selenium (software)`
    //verify url ends with `Selenium_(software)`

    public static void wikipedia() throws Exception{
        WebDriver driver = new ChromeDriver() ;

        driver.get("http://en.wikipedia.org/wiki/Main_Page");    //Go to wikipedia.org
        driver.findElement(By.id("searchInput")).sendKeys("selenium webDriver", Keys.ENTER);//enter search term `selenium webdriver
        // click on search button
        driver.findElement(By.partialLinkText("Selenium (software)")).click(); //click on search result `Selenium (software)`

        Thread.sleep(4000);
        String link = driver.getCurrentUrl();// to get a like as a String
        if (link.endsWith("Selenium_(software)")){//to verify the url
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED" );
        }



        driver.quit();
    }
}

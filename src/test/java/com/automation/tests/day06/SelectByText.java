package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);

        // or we can use it like this

        WebElement simpleDropdown =driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);
        selectSimpleDropdown.selectByVisibleText("Option 2");// select by visible text
        BrowserUtils.wait(2);


        // select date of birth
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));



        selectYear.selectByVisibleText("2000");
        selectMonth.selectByVisibleText("June");

        BrowserUtils.wait(2);

        // select all months one by one
        //.getOptions(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth : months){
            //get the month name and select based on that
            selectMonth.selectByVisibleText(eachMonth.getText());
            BrowserUtils.wait(1);
        }

        selectDay.selectByVisibleText("12");
        BrowserUtils.wait(5);

        // select state
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Texas");

        // option that is currently selected
        // getFirstSelectedOption -- returns a WebElement, that's why we need to call getText
        // getText() retrieves visible text from the WebElement
        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("Texas")){
            System.out.println("TEST PASSED"    );
        }else {
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement stateOption : states){
            System.out.println(stateOption.getText());
        }

        BrowserUtils.wait(2);
        driver.quit();
    }
}

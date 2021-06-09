package com.HWfromSeleniumLaskClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW2 {
    /*
    TC 2: HRMS blank username and password validation
Navigate to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Leave username and password field empty
Click on login button
Verify error message with text "Username cannot be empty" is displayed
     */
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndLaunchApplication(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test
    public void login(){

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement userPassIsEmpty = driver.findElement(By.xpath("//span[text()='Username cannot be empty']"));

        String text = userPassIsEmpty.getText();
        String actualText = "Username cannot be empty";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(text,actualText);
        System.out.println(text);
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }


}

package com.HWfromSeleniumLaskClass;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW3 {
    /*
    TC 2: HRMS invalid credentials validation
Navigate to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Enter valid username and wrong password
Click on login button
Verify error message with text "Invalid credentials" is displayed
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
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("WrongPassword");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement invalid = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));

        String text = invalid.getText();
        String actualText = "Invalid credentials";

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

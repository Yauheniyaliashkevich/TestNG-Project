package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
open the browser
JIRA
US 123456 - valid login test for hrm application
           Launch the application on the browser
           Enter username and password
           Click on login button
           Verify xyz icon on the homepage
close the browser
 */

public class LoginTest1 {

    WebDriver driver;

    @BeforeTest
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver=new ChromeDriver();

        //launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    public void validLogin(){
        /*WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys("Admin");*/
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        if(welcomeAttribute.isDisplayed()){
            System.out.println("Test is valid and passed");
        }else{
            System.out.println("Test is failed");
        }

    }

    @Test
    public void validationOfTitle(){
        String expectedTitle = "Human Management System";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test is final and title is same");
        }else{
            System.out.println("Test is failed");
        }
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }





}

package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

public class HWTogether {

    WebDriver driver;

    @BeforeTest
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver=new ChromeDriver();

        //launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLogin(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement errorField = driver.findElement(By.id("spanMessage"));

        String receivingText= errorField.getText();
        String actualText = "Password cannot be empty";

        Assert.assertEquals(receivingText,actualText);
        System.out.println("Test is passed");

        /*if(receivingText.equals(actualText)){
            System.out.println("Test is passed and error is displayed");
        }else{
            System.out.println("Test is failed and error is not available");
        }*/
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnableAndDisable {
    @Test(enabled =false)
    public void firstMethod(){
        System.out.println("This execution should come later");
    }

    @Test(priority = 1,enabled=false)
    public void secondMethod(){
        System.out.println("This execution should come first");
    }

    @Test(priority=2,enabled=false)
    public void thirdMethod(){
        System.out.println("This execution should come in the end");
    }
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

    @Test(priority = 1,enabled =true )
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

    @Test(priority =1,enabled = false)
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
    @Test(priority =2,enabled = true)
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
        driver.quit();
    }
}

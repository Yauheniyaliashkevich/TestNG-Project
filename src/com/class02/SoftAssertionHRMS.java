package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionHRMS {
    WebDriver driver;

    @BeforeMethod
    public void launchApplication(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void loginAndValidateTitle(){
        String title="Human Management System";
        String actualTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,title);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement welcomeMessage = driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        String  receivedValue = welcomeMessage.getText();
        String existedValue = "Welcome Admin12345";
        softAssert.assertEquals(receivedValue,existedValue);
        System.out.println("My test case is not working according to the user story");
        softAssert.assertAll();

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

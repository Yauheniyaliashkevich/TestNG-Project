package com.class04;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HWKseniia {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void launchApplication() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        // launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    @Test(dataProvider = "addedEmployees", groups = "regression")
    public void login(String firstName, String lastName, String userName, String password, String confirmPassword) {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("user_name")).sendKeys(userName);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("re_password")).sendKeys(confirmPassword);
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
        /*try {
            FileUtils.copyFile(screenshotAs, new File("Screenshots/HRMS/Added Employees.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        WebElement addedEmployee = driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1"));
        Assert.assertTrue(addedEmployee.isDisplayed(), "Name is displayed");
    }

    @DataProvider
    public Object[][] addedEmployees() {
        Object[][] data = new Object[5][5];
        data[0][0] = "Ksenia ";
        data[0][1] = "Brown";
        data[0][2] = "ksenia1";
        data[0][3] = "ksenia123!K";
        data[0][4] = "ksenia123!K";
        data[1][0] = "Ksenia ";
        data[1][1] = "White";
        data[1][2] = "ksenia2";
        data[1][3] = "ksenia123!K";
        data[1][4] = "ksenia123!K";
        data[2][0] = "Ksenia ";
        data[2][1] = "Black";
        data[2][2] = "ksenia3";
        data[2][3] = "ksenia123!K";
        data[2][4] = "ksenia123!K";
        data[3][0] = "Ksenia ";
        data[3][1] = "Red";
        data[3][2] = "ksenia4";
        data[3][3] = "ksenia123!K";
        data[3][4] = "ksenia123!K";
        data[4][0] = "Ksenia ";
        data[4][1] = "Yellow";
        data[4][2] = "ksenia5";
        data[4][3] = "ksenia123!K";
        data[4][4] = "ksenia123!K";
        return data;
    }

}

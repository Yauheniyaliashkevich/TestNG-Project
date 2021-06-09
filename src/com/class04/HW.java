package com.class04;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;


public class HW {
    /*
    HRMS Add Employee:
Open chrome browser
Go to HRMS
Login into the application
Add 5 different Employees and create login credentials by providing:
First Name
Last Name
Username
Password
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.
  */
    public WebDriver driver;


    @BeforeMethod (alwaysRun = true)
    public void openBrowserAndLaunchApp (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(url);
        //driver.manage().window().maximize();
    }

    @Test (groups = "Create Employee")
    public void login() throws InterruptedException {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        Thread.sleep(3000);
    }

    @DataProvider
    public Object[][] credentials(){
        Object [][] data ={
            { "Love", "Vavovevyvu", "Lovelove1", "Love$!@#9345Evh!4", "Love$!@#9345Evh!4" },
            {"Hate","Pjdchsdcv","Hatehate2","Hate$%^9836Fjgbc!","Hate$%^9836Fjgbc!"},
            {"Enjoy","Lkdhfva","Enjoyenjoy12","JEnc&^$845dF!","JEnc&^$845dF!"},
            {"Glad", "Jjfjswer", "Gladglad34", "Isfs^%#5345f!1!", "Isfs^%#5345f!1!"},
            {"Like", "Hskdascdsd", "Likelike21", "KFJd&%$7we76V$#", "KFJd&%$7we76V$#"}
        };
        return data;

    }

    @Test (dataProvider = "credentials",groups = "Create Employee" )
    public void addEmployee (String firstName, String lastName, String userName, String password,String passwordConf) throws InterruptedException {

        login();
        WebElement PimBtn=driver.findElement(By.id("menu_pim_viewPimModule"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",PimBtn);

        WebElement addEmployeeBtn=driver.findElement(By.id("menu_pim_addEmployee"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",addEmployeeBtn);

        WebElement firstName1 = driver.findElement(By.id("firstName"));
        firstName1.sendKeys(firstName);
        WebElement lastName1 = driver.findElement(By.id("lastName"));
        lastName1.sendKeys(lastName);
        WebElement createCB = driver.findElement(By.id("chkLogin"));
        js.executeScript("arguments[0].click()",createCB);

        WebElement userName1 = driver.findElement(By.id("user_name"));
        userName1.sendKeys(userName);
        WebElement password1 = driver.findElement(By.id("user_password"));
        password1.sendKeys(password);
        WebElement passwordConfirm1 = driver.findElement(By.id("re_password"));
        passwordConfirm1.sendKeys(passwordConf);

        WebElement saveBtn = driver.findElement(By.id("btnSave"));
        js.executeScript("arguments[0].click()",saveBtn);
    }

    @DataProvider
    public Object [][] verificationEmployee (){
        Object [][] data={
                {"Lovelove1", "Love$!@#9345Evh!4","Love"},
                {"Hatehate2","Hate$%^9836Fjgbc!","Hate"},
                {"Enjoyenjoy12","JEnc&^$845dF!","Enjoy"},
                {"Gladglad34", "Isfs^%#5345f!1!","Glad"},
                {"Likelike21", "KFJd&%$7we76V$#","Like"},
        };
        return data;
    }

    @Test (dataProvider = "verificationEmployee",groups = "verification")
    public void verification(String userName, String password,String firstName) throws InterruptedException {
        WebElement username1 = driver.findElement(By.id("txtUsername"));
        username1.sendKeys(userName);
        WebElement password1 = driver.findElement(By.id("txtPassword"));
        password1.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        //WebDriverWait wait=new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='welcome']")));
        WebElement welcome = driver.findElement(By.id("welcome"));
        String welcomeText = welcome.getText();
        String actualText = "Welcome "+firstName+"";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(welcomeText,actualText);
        System.out.println(welcomeText);
        softAssert.assertAll();
        Thread.sleep(3000);
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File employee = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try{
            File deskScreenshot = new File("screenshot/employeeHWClass04/"+userName+".png");
            FileUtils.copyFile(employee, deskScreenshot);
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }







}


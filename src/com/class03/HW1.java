package com.class03;

import com.class02.SoftAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /*
    HRMS Add Employee:
Open chrome browser
Go to “http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Add a picture to the profile
Verify Employee has been added successfully
Close the browser
     */

    public WebDriver driver;
    @BeforeTest
    public void openBrowser (){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test (priority = 2)
    public void isDisplayed() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("menu_pim_addEmployee")).click();

        SoftAssert softAssert = new SoftAssert();
        WebElement fullName = driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']"));
        WebElement empID = driver.findElement(By.xpath("//label[text()='Employee Id']"));
        WebElement photograph = driver.findElement(By.xpath("//label[text()='Photograph']"));
        softAssert.assertTrue(fullName.isDisplayed());
        softAssert.assertTrue(empID.isDisplayed());
        softAssert.assertTrue(photograph.isDisplayed());
        softAssert.assertAll();

    }

    @Test (priority = 3)
    public void provide (){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement firstName= driver.findElement(By.id("firstName"));
        firstName.sendKeys("Yauheniya");
        WebElement lastName= driver.findElement(By.id("lastName"));
        lastName.sendKeys("Liashkevich");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='photofile']"));
        chooseFile.sendKeys("/Users/yauheniyaliashkevich/Desktop/Photo.HEIC");
        WebElement saveButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
        saveButton.click();


    }
    @Test (priority = 4)
    public void empList() {

        WebElement empListBtn = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        empListBtn.click();

        boolean flag = true;
        while (flag) {
            List<WebElement> empIDs = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (WebElement empID : empIDs) {
                if (empID.getText().contains("Yauheniya")) {
                    System.out.println("Employee: " + empID.getText() + " has been added successfully");
                    flag = false;
                    break;
                }

            }
            WebElement nextBtn= driver.findElement(By.xpath("//a[text()='Next']"));
            nextBtn.click();

        }


    }

}

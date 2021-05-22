package com.class01;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class InClassTask2 {
    @Test
    public void method1(){ System.out.println("I am a method1");
    }
    @Test
    public void method2(){ System.out.println("I am a method2");
    }
    @BeforeMethod
    public void beforeMethod(){ System.out.println("I am before every method");
    }
    @AfterMethod
    public void afterMethod(){ System.out.println("I am after every method");
    }
    @BeforeClass
    public void beforeClass(){ System.out.println("I am before class");
    }
    @AfterClass
    public void afterClass(){ System.out.println("I am after class");
    }



}

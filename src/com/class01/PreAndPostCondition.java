package com.class01;

import org.testng.annotations.*;

public class PreAndPostCondition {
    @BeforeMethod
    public void beforeEveryTestMethod(){
        System.out.println("I am before method function will be execute before every test");
    }
    @AfterMethod
    public void afterEveryTestMethod(){
        System.out.println("I am after method function will be execute before every test");
    }
    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("I am before method");
    }
    @AfterTest
    public void afterTestMethod(){
        System.out.println("I am after method");
    }
    @Test
    public void firstFunction(){
        System.out.println("I an first Function");
    }
    @Test
    public void secondFunction(){
        System.out.println("I an second Function");
    }
    @Test
    public void thirdFunction(){
        System.out.println("I an third Function");
    }
}

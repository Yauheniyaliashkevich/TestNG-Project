package com.class01;

import org.testng.annotations.*;

public class InClassTask1 {
    @Test
    public void method1(){
        System.out.println("I am a method1");
    }
    @Test
    public void method2(){
        System.out.println("I am a method2");
    }
    @Test
    public void method3(){
        System.out.println("I am a method3");
    }
    @Test
    public void method4(){
        System.out.println("I am a method4");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before every method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after every method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }
}

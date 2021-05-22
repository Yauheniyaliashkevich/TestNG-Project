package com.class01;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {
    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("I am before method");
    }
    @Test
    public void bclass(){
        System.out.println("I an b test");
    }
    @Test
    public void cclass(){
        System.out.println("I an c test");
    }





}

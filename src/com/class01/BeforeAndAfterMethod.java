package com.class01;

import org.testng.annotations.Test;

public class BeforeAndAfterMethod {
    @Test(groups = "sprint4")
    public void method1(){
        System.out.println("Method1");
    }
    @Test(groups = "sprint4")
    public void method2(){
        System.out.println("Method2");
    }
    @Test
    public void method3(){
        System.out.println("Method3");
    }
    @Test
    public void method4(){
        System.out.println("Method4");
    }
}

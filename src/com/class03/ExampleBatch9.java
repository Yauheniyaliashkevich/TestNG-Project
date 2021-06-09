package com.class03;

import org.testng.annotations.Test;

public class ExampleBatch9 {

    @Test (groups = "smoke")
    public void firstFunction(){
        System.out.println("I am smoke test");
    }

    @Test (groups = "smoke")
    public void secondFunction(){
        System.out.println("I am smoke2 test");
    }

    @Test (groups = "regression")
    public void thirdFunction(){
        System.out.println("I am ccccc test");
    }

    @Test (groups = "smoke")
    public void fourthFunction(){
        System.out.println("I am bbbbb test");
    }
}

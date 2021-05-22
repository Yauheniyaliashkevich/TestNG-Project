package com.class02;

import org.testng.annotations.Test;

public class PriorityDemo {

    @Test(priority=1)
    public void firstMethod(){
        System.out.println("This execution should come later");
    }

    @Test(priority=1)
    public void secondMethod(){
        System.out.println("This execution should come first");
    }

    @Test(priority=3)
    public void thirdMethod(){
        System.out.println("This execution should come in the end");
    }


}

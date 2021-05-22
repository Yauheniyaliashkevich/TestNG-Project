package com.class02;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {


    @Test
    public void softAssertionValidation(){
        String expectedText= "This is my testing world";
        String actualText = "THIS is my testing world";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expectedText,actualText);
        System.out.println("My code after first assertion");

        softAssert.assertTrue(false);
        System.out.println("My code after second assertion");

        softAssert.assertFalse(true);
        System.out.println("My code after third assertion");


        String expectedTextSecond= "This is my testing world";
        String actualTextSecond = "This is my testing world";
        softAssert.assertEquals(actualTextSecond,expectedTextSecond);

        softAssert.assertAll();

        /*softAssert.assertNotEquals(expectedTextFirst,actualTextSecond);*/
    }
}

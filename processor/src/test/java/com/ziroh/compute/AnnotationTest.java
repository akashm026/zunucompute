package com.ziroh.compute;


import com.ziroh.annotation.includeslambdafunction;

public class AnnotationTest {

    @includeslambdafunction
    public String testqwerty(String testValue){
        System.out.println("Hello World");
        return "Hello World";
    }

}

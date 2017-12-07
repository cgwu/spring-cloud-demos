package com.sam.guavademo.proxy;

/**
 * Created by sam on 17-12-7.
 */
public class Target implements TargetInterface {

    public void SayHello(){
        System.out.println("Hello");
    }
    public int sum(int a, int b) {
        System.out.printf("sum(%d,%d) called\n",a,b);
        return a+b;
    }
}
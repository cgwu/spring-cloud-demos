package com.sam.guavademo.proxy;

import com.google.common.reflect.Reflection;

import java.lang.reflect.Proxy;

/**
 * Created by sam on 17-12-7.
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        Target t=new Target();
        TargetInvocationHandler handler=new TargetInvocationHandler(t);

//        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
//                t.getClass().getClassLoader(),
//                t.getClass().getInterfaces(),
//                handler);

        TargetInterface proxy2 = Reflection.newProxy(TargetInterface.class, handler);
        TargetInterface proxy = Reflection.newProxy(TargetInterface.class, new TargetInvocationHandler(proxy2));

        proxy.SayHello();

        System.out.println("----");

        int b=proxy.sum(10, 20);
        System.out.println(b);
    }
}

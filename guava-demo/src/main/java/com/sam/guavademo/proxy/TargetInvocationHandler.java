package com.sam.guavademo.proxy;

/**
 * Created by sam on 17-12-7.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TargetInvocationHandler implements InvocationHandler {

    private Object object;

    public TargetInvocationHandler(Object obj) {
        this.object = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args2)
            throws Throwable {
//        doBefore();
        System.out.println("before invoke: " + method);
        Object result = method.invoke(object, args2);
        System.out.println("after invoke: " + method);
//        doAfter();
        return result;
    }

    public void doBefore() {
        System.out.println("do before");
    }

    public void doAfter() {
        System.out.println("do after");
    }
}

package com.mmh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserProxy implements InvocationHandler {

    private User user;

    public UserProxy(User user) {
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.isDefault()) {
            System.out.println("调用此处的方法为：" + method.getName());
        }
        return method.invoke(user,args);
    }
}

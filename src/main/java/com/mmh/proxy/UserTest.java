package com.mmh.proxy;

import java.lang.reflect.Proxy;

public class UserTest {

    public static void main(String[] args) {
        User user = new User() {
            @Override
            public String say() {
                return "say hi";
            }
        };

        user = (User) Proxy.newProxyInstance(User.class.getClassLoader(),new Class[]{User.class},new UserProxy(user));
        System.out.println(user.say());
    }
}

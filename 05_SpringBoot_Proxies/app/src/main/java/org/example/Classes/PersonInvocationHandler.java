package org.example.Classes;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
Below PersonInvocationHandler class is meant to tell the jvm that the proxies that will be invoked by jvm , must have
 this definition means this code should execute whenever proxies are invoked.

 Below we are just overriding pre defined methods and we are specifically working with Invocationhandler so this is a
  dynamic proxy to be specific jdk one.
 */
//You implement InvocationHandler ONLY when YOU are manually creating a JDK dynamic proxy.
//When we implement InvocationHandler we need to only override 1 method i.e invoke.

public class PersonInvocationHandler implements InvocationHandler {
//   We have used final keyword becoz once this variable points to an object, it cannot point to another object later.
    private final Person person;

    public PersonInvocationHandler(Person person1){
        this.person = person1;
    }

    @Override
//    Method is a class from Java Reflection API
  /*  It represetns a real method at runtime.If any class has any method like sayhello() then this Method class can
  represent this method.

   */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("Hi");
        /*
        Call this method on the real object using the given arguments.Here this method refers to The method that the user called on the proxy object.
         */
        return method.invoke(person, args);
    }

}

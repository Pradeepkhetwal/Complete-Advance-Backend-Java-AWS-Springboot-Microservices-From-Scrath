package org.example.Classes;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
        return null;
    }

}

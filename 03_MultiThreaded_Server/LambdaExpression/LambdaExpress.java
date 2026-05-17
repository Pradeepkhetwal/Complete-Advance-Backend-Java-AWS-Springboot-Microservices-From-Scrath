package LambdaExpression;

//Here we will learn about the concept of lambda expression and when to use them.

/*
Look there is one concept of functional interface, so it's a kind of interface that have exact one abstract method.

So for those interfaces instead of implementing one class and then overriding it's method and then use it by the
implemented class object we can directly overrdie the method of that interface without any class. We can do it by
labmda expression.
 */

interface Car{
    void run();
}
public class LambdaExpress {
    public static void main(String[] args) {
//        Creating lambda function.
//Whatever function (lamda) we write it will override the interface method.
//        This helps writing shorter and cleaner code.

       /*In simple words for functinal interfaces lambdaexpression is used and for normal interfaces anonymous class
        is used.*/
        Car obj = ()->{
            System.out.println("Running");
        };

        obj.run();
    }
}

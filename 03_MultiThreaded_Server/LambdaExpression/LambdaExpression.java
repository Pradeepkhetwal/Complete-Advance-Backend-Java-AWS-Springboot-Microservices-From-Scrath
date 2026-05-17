package LambdaExpression;
//class AnyonymousDemo implements LambdaExpression.LambdaExpression.DemoAno {
//    public void display(){
//        System.out.println("Display");
//    }
//    @Override
//    public void meth1(){
//        System.out.println("I am meth1");
//    }
//    @Override
//    public void meth2(){
//        System.out.println("I am meth2 ");
//    }
//}
public class LambdaExpression {
/*

 */

    interface DemoAno{
        void meth1();
        void meth2();
    }


    public static void main(String[] args) {
//        AnyonymousDemo obj = new AnyonymousDemo();
//        obj.display();
//        obj.meth1();
//        obj.meth2();

/*
Now in above i've commented the code out , understand this that inorder to use interface methods we need to create a
class and then create object for it , matlab sirf ek call k lie inta sara code likhna padta hai. To solve this issue
we have a concept called as Anonymous class means we can create object without creating an actual class and that
class is called anonymous class.

Means we not need to create a class to use the methods of this interface we can simply create a type of this
interface and initilize it with new keyword just as what i've done below.

//Anonymous classes are not only limited to interfaces , they are used with abstract classes and concrete classes as
well.
 */
//Anonymous Class
        DemoAno obj = new DemoAno() {
            @Override
            public void meth1() {
                System.out.println("hello meth1");
            }

            @Override
            public void meth2() {
                System.out.println("Hello from meth2");
            }
        };

        obj.meth1();
    }
}

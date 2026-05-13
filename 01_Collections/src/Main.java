import javax.swing.text.html.Option;
import java.util.*;

public class Main{
    public static void main(String[] args){


//        ArrayList is an class which at the end implements a Collection interface.

//        List is also an interface which extends collection interface.

//        ArrayList implements List , means list is parent for Arraylist. Means every Arraylist is list but viceversa
//        is not true

        List<Object> arr = new ArrayList<>();


//        Map you already know.

        Map<Integer,String> mp = new HashMap<>();

        mp.put(1,"Pradeep");
        mp.put(2,"Dummy");

        for(Map.Entry<Integer,String> e:mp.entrySet()){
            System.out.println(e.getKey()+"------");
            System.out.println(e.getValue());
        }

//        You can study about Set and ImmutableList by your own.


//        Optional -: Optional ek aisa container hai that is used to handle null values gracefully.



    }
}
package lesson4.classwork;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Cat kiisu = new Cat("kiisu", "Person");
        Cat kiisu2 = new Cat("kiisu", "Person");
        Cat bean = new Cat("bean", "Person");
//
//        System.out.println(kiisu.getName());
//        System.out.println(bean.getName());
//
//        System.out.println(kiisu.getOwner());
//        System.out.println(bean.getOwner());
//
//        kiisu.greet();
//        kiisu.roll();
//        bean.roll();

        System.out.println(
                kiisu.equals(kiisu2)
        );

        Set<Cat> cats = new HashSet<>();

        cats.add(kiisu);
        cats.add(kiisu2);

        System.out.println(cats);
    }
}

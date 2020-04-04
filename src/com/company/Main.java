package com.company;

import com.company.items.DiscountedItem;
import com.company.items.Item;
import com.company.reflect.Reflection;
import com.company.shapes.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;

public class Main {


    //4. Inheritance and reflection
    //ex 1-7
    //по желанию рефлексия - ex 8-13
    public static void main(String[] args) {

        //exs 1 - 5,7
        LabeledPoint p1 = new LabeledPoint("green",1,1);
        LabeledPoint p2 = null;
        try {
            p2 = p1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));


        Circle c = new Circle(p1,10);
        Circle c2 = c.clone();

        System.out.println(c == c2);
        System.out.println(c.equals(c2));

        //ex 6
        System.out.println("---- ex 6 ----");
        DiscountedItem item1 = new DiscountedItem("shirt",100,20);


        Item item2 = new Item("shirt",100);

        DiscountedItem item3 = new DiscountedItem("shirt",100,10);

        System.out.println("symmetry test");
        System.out.println(item2.equals(item1));
        System.out.println(item1.equals(item2));

        System.out.println("transitive test");
        System.out.println("item2.equals(item3)");
        System.out.println(item2.equals(item3));
        System.out.println(item3.equals(item2));

        System.out.println("item1.equals(item3)");
        System.out.println(item1.equals(item3));
        System.out.println(item3.equals(item1));


        Reflection reflectionTest = new Reflection();
        //ex 8
        System.out.println("--- ex 8 ---");
        reflectionTest.getTypes("ADS");

        //ex 9
        System.out.println("--- ex 9 ---");
        String str = reflectionTest.universalToString(new Rectangle(p1,10,10));
        System.out.println(str);

        //ex 10
        System.out.println("--- ex 10 ---");
        reflectionTest.getMethods();

        //ex 11
        System.out.println("--- ex 11 ---");
        reflectionTest.sayHello();

        //ex 12
        System.out.println("--- ex 12 ---");
        reflectionTest.benchmark();

    }


}

package com.company.reflect;

import com.company.Outer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection {
    //ex 8
    public <T> void getTypes(T gen){
        int[] array = new int[5];
        System.out.println(array.getClass());

        System.out.println(gen.getClass());

        Outer.InnerClass innerClass = new Outer(). new InnerClass();
        System.out.println(innerClass.getClass());
        System.out.println(int.class);
    }

    //ex 9
    public String universalToString(Object o){
        Class c = o.getClass();
        Field[] objSuperF = c.getFields();
        Field[] objF = c.getDeclaredFields();


        String toString = o.getClass().getName()+"{";


        //System.out.println("super fields");
        for(Field f : objSuperF){

            try {
                f.setAccessible(true);

                if(!f.getType().isPrimitive() && f.get(o).getClass() != String.class) {
                    toString += f.getName()+"="+universalToString(f.get(o))+", ";
                    //System.out.println(">>> "+f.getName()+" "+f.get(o));
                }else {
                    toString += f.getName()+"="+f.get(o)+", ";
                    //System.out.println(f.getName()+" "+f.get(o));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        //System.out.println("this fields");
        for(Field f : objF){
            try {

                f.setAccessible(true);

                if(!f.getType().isPrimitive() && f.get(o).getClass() != String.class) {
                    toString += f.getName()+"="+universalToString(f.get(o))+", ";
                    //System.out.println(">> "+f.getName()+" "+f.get(o));
                }else {
                    toString += f.getName()+"="+f.get(o)+", ";
                    //System.out.println(f.getName()+" "+f.get(o));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        toString += "}";

        return toString;
    }

    //ex 10
    public void getMethods(){
        int[] x = new int[5];

        Class cl = x.getClass();

        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                                m.getReturnType().getCanonicalName() + " " +
                                m.getName() +
                                Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }

    //ex 11
    public void sayHello(){
        try {
            Class c = Class.forName("java.lang.System");

            Field f = c.getField("out");

            Class c2 = f.getType();
            Method printlnMethod = c2.getDeclaredMethod("println", String.class);

            Object object = f.get(null);

            printlnMethod.invoke(object,"Hello, World");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //ex
    public void benchmark(){
        long s,f,t1,t2;

        s = System.nanoTime();
        for(int i = 0; i < 10_000;i++){
            sayHello();
        }
        f = System.nanoTime();
        t1 = f - s;
        System.out.println("reflect time = " + (t1 / 1_000_000)+" ms");

        s = System.nanoTime();
        for(int i = 0; i < 10_000;i++){
            System.out.println("Hello, World");
        }
        f = System.nanoTime();
        t2 = f - s;




        System.out.println("reflect time = " + (t1 / 1_000_000)+" ms");
        System.out.println("standard way time = " +(t2 / 1_000_000)+" ms");


    }
}

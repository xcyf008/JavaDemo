package reflectiondemo;

import java.lang.reflect.Method;

/**
 * JavaDemo
 * reflectiondemo
 * Created by timothy on 16/9/9.
 */
public class ReflectApp {

    public static void main(String[] args) {

        Animal animal = new Animal();
        printPublicMethods(animal);
    }

    public static void printPublicMethods(Object o) {

        if (o == null) return;

        Class c = o.getClass();
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println("===========================");
            System.out.println("Method Name: " + m.getName());
            System.out.println("Return Type: " + m.getReturnType().getName());
            System.out.println("===========================");
        }
    }
}

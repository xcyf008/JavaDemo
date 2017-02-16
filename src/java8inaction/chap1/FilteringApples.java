package java8inaction.chap1;

import java8inaction.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * JavaDemo
 * java8inaction.chap1
 * Created by timothy on 16/10/21.
 */
public class FilteringApples {
    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                new Apple("green", 80),
                new Apple("red", 200),
                new Apple("yellow", 180),
                new Apple("red", 90),
                new Apple("yellow", 100)
        );
        List<Apple> greenApples = filterApples(apples, FilteringApples::isGreenApple);
        System.out.println("===========Green Apples===========");
        greenApples.forEach(System.out::println);

        List<Apple> heavyApples = filterApples(apples, FilteringApples::isHeavyApple);
        System.out.println("===========Heavy Apples===========");
        heavyApples.forEach(System.out::println);
    }

    public static boolean isGreenApple(Apple apple) {
        return apple.getColor().equalsIgnoreCase("green");
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            if (predicate.test(a)) {
                result.add(a);
            }
        }

        return result;
    }
}

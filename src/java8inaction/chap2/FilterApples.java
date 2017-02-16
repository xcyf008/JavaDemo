package java8inaction.chap2;

import java8inaction.Apple;
import java8inaction.chap1.FilteringApples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * JavaDemo
 * java8inaction.chap2
 * Created by timothy on 16/10/24.
 */
public class FilterApples {

    public static void main(String[] args) {

        List<Apple> appleList = Arrays.asList(
                new Apple("green", 80),
                new Apple("red", 200),
                new Apple("yellow", 180),
                new Apple("red", 90),
                new Apple("yellow", 100)
        );
        List<Apple> greenApples = filterApples(appleList, FilteringApples::isGreenApple);
        System.out.println("===========Green Apples===========");
        greenApples.forEach(System.out::println);

        List<Apple> heavyApples = filterApples(appleList, FilteringApples::isHeavyApple);
        System.out.println("===========Heavy Apples===========");
        heavyApples.forEach(System.out::println);
    }

    public static <T> List<T> filterApples(List<T> data, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T t : data) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}

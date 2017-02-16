package java8inaction.chap3;

import java8inaction.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.*;

/**
 * JavaDemo
 * java8inaction.chap3
 * Created by timothy on 16/10/24.
 */
public class Lambdas {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        List<Apple> greenApples = filter(apples, a -> a.getColor().equalsIgnoreCase("green"));
        apples.sort(comparingDouble(Apple::getWeight).reversed().thenComparing(Apple::getColor));

        Predicate<Apple> heavyPredicate = apple -> apple.getWeight() > 100;
        Predicate<Apple> notHeavyPredicate = heavyPredicate.negate();
        Predicate<Apple> heavyAndGreenPredicate = heavyPredicate.and(
                apple -> apple.getColor().equalsIgnoreCase("green"));

        Function<Integer, Integer> f1 = i -> i + 1;
        Function<Integer, Integer> f2 = i -> i * 3;
        Function<Integer, Integer> f3 = f1.andThen(f2);
        Function<Integer, Integer> f4 = f1.compose(f2);
        System.out.println(f3.apply(2));
        System.out.println(f4.apply(2));
    }

    public static List<Apple> filter(List<Apple> apples, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple item : apples) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    @FunctionalInterface
    interface ApplePredicate {
        boolean test(Apple apple);
    }
}
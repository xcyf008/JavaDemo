package java8inaction.chap3;

import java8inaction.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * JavaDemo
 * java8inaction.chap3
 * Created by timothy on 16/10/24.
 */
public class Sorting {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        Comparator<Apple> c = (a, b) -> Double.valueOf(a.getWeight()).compareTo(Double.valueOf(b.getWeight()));
        apples.sort(c);
        apples.sort(new AppleComparator());
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Double.valueOf(o1.getWeight()).compareTo(Double.valueOf(o2.getWeight()));
            }
        });
        apples.sort(Comparator.comparingDouble(Apple::getWeight));
    }

    public static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return Double.valueOf(o1.getWeight()).compareTo(Double.valueOf(o2.getWeight()));
        }
    }
}

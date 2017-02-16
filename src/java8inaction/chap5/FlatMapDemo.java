package java8inaction.chap5;

import java.util.Arrays;

/**
 * JavaDemo
 * java8inaction.chap5
 * Created by timothy on 2016/11/21.
 */
public class FlatMapDemo {

    public static void main(String[] args) {
        String[] array = {"hello", "World"};
        Arrays.stream(array).map(i -> i.split("")).forEach(System.out::println);
    }
}

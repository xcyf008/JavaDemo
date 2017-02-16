package java8inaction.chap3;

import java8inaction.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * JavaDemo
 * java8inaction.chap3
 * Created by timothy on 2016/10/26.
 */
public class ExecuteAround {

    public static void main(String[] args) {

        String oneline = processFile(BufferedReader::readLine);
        Apple apple = createApple(Apple::new);
        Function3<String, Double, Apple> newApple = Apple::new;
        Apple green = newApple.apply("green", 10.0);
    }

    public static String processFile(BufferedReaderProcessor processor) {
        String result = "";
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(""))) {
                result = processor.process(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader reader) throws IOException;
    }

    @FunctionalInterface
    public interface Function3<T1, T2, R> {

        R apply(T1 t1, T2 t2);
    }
}

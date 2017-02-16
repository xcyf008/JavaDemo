package springdemo;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/17.
 */
public class HelloImp implements HelloInterface {

    @Override
    public String hello(String name) {

        return "Hello, " + name;
    }
}

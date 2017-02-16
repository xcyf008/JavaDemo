package singleton;

/**
 * JavaDemo
 * singleton
 * Created by timothy on 16/9/25.
 * 非线程安全，不推荐使用
 */
public class Singleton1 {

    private static Singleton1 singleton;

    private Singleton1() {}

    public static Singleton1 getSingleton() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}

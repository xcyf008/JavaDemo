package singleton;

/**
 * JavaDemo
 * singleton
 * Created by timothy on 16/9/25.
 * 线程安全，兼具效率，但是不具备严格延迟加载，在不会占用比较大的资源的情况下推荐使用
 */
public class Singleton3 {

    private static final Singleton3 singleton = new Singleton3();

    private Singleton3() {}

    public static Singleton3 getSingleton() {

        return singleton;
    }
}

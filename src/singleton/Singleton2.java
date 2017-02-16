package singleton;

/**
 * JavaDemo
 * singleton
 * Created by timothy on 16/9/25.
 * 延迟加载，线程安全，但是效率低
 */
public class Singleton2 {
    private static Singleton2 singleton;
    private Singleton2() {}

    public synchronized static Singleton2 getSingleton() {
        if (singleton == null) {
            singleton = new Singleton2();
        }

        return singleton;
    }
}

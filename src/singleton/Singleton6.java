package singleton;

/**
 * JavaDemo
 * singleton
 * Created by timothy on 16/9/25.
 * 双重检查，线程安全，兼具效率，但是在java 1.5之后才能达到预期效果
 */
public class Singleton6 {
    private volatile static Singleton6 singleton;

    private Singleton6() {}

    public static Singleton6 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton6.class) {
                if (singleton == null) {
                    singleton = new Singleton6();
                }
            }
        }
        return singleton;
    }
}

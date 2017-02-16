package singleton;

/**
 * JavaDemo
 * singleton
 * Created by timothy on 16/9/25.
 * 懒加载，线程安全，兼具效率，在实例占用资源较多的情况下推荐使用
 */
public class Singleton4 {

    private Singleton4() {}

    private static class SingletonHolder {
        private static final Singleton4 Singleton = new Singleton4();
    }

    public static final Singleton4 getSingleton() {
        return SingletonHolder.Singleton;
    }
}

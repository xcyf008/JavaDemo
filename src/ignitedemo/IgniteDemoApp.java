package ignitedemo;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMemoryMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;

import java.util.Random;

/**
 * JavaDemo
 * ignitedemo
 * Created by timothy on 16/8/22.
 */
public class IgniteDemoApp {

    public static void main(String[] args) {

        IgniteConfiguration igniteConf = new IgniteConfiguration();
        igniteConf.setClientMode(true);
        try (Ignite ignite = Ignition.start(igniteConf)) {
            IgniteCache<String, Student> cache = createPersonCache(ignite);
            initCache(cache);
            System.out.println(cache.get("10"));
        }
    }

    public static IgniteCache<String, Student> createPersonCache(Ignite ignite) {

        CacheConfiguration<String, Student> conf = new CacheConfiguration<>();
        conf.setName("Student");
        conf.setCacheMode(CacheMode.LOCAL);
        conf.setMemoryMode(CacheMemoryMode.ONHEAP_TIERED);
        conf.setOffHeapMaxMemory(10 * 1024 * 1024);

        return ignite.getOrCreateCache(conf);
    }

    public static void initCache(IgniteCache cache) {

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Student s1 = new Student();
            s1.setId(Integer.toString(i));
            s1.setName("S" + s1.getId());
            s1.setGrade(random.nextInt(100));
            cache.put(s1.getId(), s1);
        }
    }
}

package springdemo;

import configurations.CDPlayerConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class SgtPeppersTest {

    @Autowired
    private CompactDisc sgtPepperts;

    @Test
    public void play() throws Exception {

        Assert.assertNotNull(sgtPepperts);
    }

}
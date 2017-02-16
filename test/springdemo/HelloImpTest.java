package springdemo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/17.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class HelloImpTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeClass
    public static void beforeSetUpClass() {

        context = new ClassPathXmlApplicationContext("resources/spring-ioc.xml");
    }

    @Test
    public void hello() {

        HelloImp hello1 = (HelloImp) context.getBean("helloInterface");
        Assert.assertEquals("Hello, Timothy", hello1.hello("Timothy"));

        HelloImp hello2 = (HelloImp) context.getBean("helloInterface");
        Assert.assertSame(hello1, hello2);

        Assert.assertEquals(hello1.hashCode(), hello2.hashCode());

    }

    @Test
    public void test_PetShopService() {

        PetShopService petShopService = context.getBean("petShopService", PetShopService.class);
        String petName = petShopService.getPetName(1);
        Assert.assertEquals("Kitty", petName);

        System.out.println("=====pet shop service1 hashcode");
        System.out.println(petShopService.hashCode());
        System.out.println(petShopService.getPetDao().hashCode());

        PetShopService petShopService2 = context.getBean("petShopService", PetShopService.class);
        System.out.println("=====pet shop service2 hashcode");
        System.out.println(petShopService2.hashCode());
        System.out.println(petShopService2.getPetDao().hashCode());
    }

}
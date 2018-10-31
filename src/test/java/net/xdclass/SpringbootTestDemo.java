package net.xdclass;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chengjiapeng on 2018/9/9.
 */
@RunWith(SpringRunner.class) //底层junit, SpringJunit4ClassRunner
@SpringBootTest(classes = {Demo2Application.class}) //启动整个springboot工程
public class SpringbootTestDemo {

    @Before
    public void testBefore() {
        System.out.println("before");
    }

    @After
    public void testAfter() {
        System.out.println("after");
    }

    @Test
    public void testOne() {
        System.out.println("test hello 11");
        TestCase.assertEquals(1,1);
    }

    @Test
    public void testTwo() {
        System.out.println("test hello 2");
        TestCase.assertEquals(1,1);
    }
}

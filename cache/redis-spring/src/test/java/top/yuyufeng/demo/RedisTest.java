package top.yuyufeng.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuyufeng on 2017/10/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-redis.xml"})
public class RedisTest {
    /*@Autowired
    private RedisTemplate<String, String> template;*/

    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOs;

   /* @Resource(name="redisTemplate")
    private BoundValueOperations<String,String> boundValueOperations;*/

    @Test
    public void testboundValueOperations() {
    }

    @Test
    public void testSet() {
        valueOs.set("aa","aabb",10, TimeUnit.MINUTES);
    }

    @Test
    public void testGet() {
        Set<String> results = valueOs.getOperations().keys("aa*");
        for (String result : results) {
            System.out.println(result);
        }

    }

}

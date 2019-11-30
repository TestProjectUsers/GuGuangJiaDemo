import com.demo.config.SpringMabtisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMabtisConfig.class)
public class TestJedis {
    @Test
    public void TestJedis1(){
        @SuppressWarnings("resource")
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.auth("123456");
//        System.out.println(jedis.ping());
//        System.out.println(jedis.info());
//        jedis.set("testJedis","hallo");
        String testJedis = jedis.get("testJedis");
        System.out.println(testJedis);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
//        jedis.lpush("list01","String1","String2","String3");
        List<String> list01 = jedis.lrange("list01", 0, -1);
        for (String s : list01) {
            System.out.println(s);
        }
//        jedis.sadd("TestSadd","1","2","2","3");
        Set<String> testSadd = jedis.smembers("TestSadd");
        for (String s : testSadd) {
            System.out.println(s);
        }
        jedis.hset("TestHash01","name","lisi");
        jedis.hset("TestHash01","password","123456");
        jedis.hset("TestHash01","email","2@qq.com");
        List<String> hmget = jedis.hmget("TestHash01", "name", "password", "email");
        for (String s : hmget) {
            System.out.println(s);
        }
    }
}

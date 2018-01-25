package net.coderchen.demo1.demo;

        import redis.clients.jedis.Jedis;

/**
 * Created by Liuyuchen on 2018/01/23.
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.85.128", 6379);
        System.out.println(jedis.get("name"));
        jedis.close();
    }
}

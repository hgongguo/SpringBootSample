package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by hgg on 2019/10/29.
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("test","Hello");
        System.out.println(jedis.get("test"));
        jedis.close();

        /*JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
        Jedis jedis1 = jedisPool.getResource();

        System.out.println("pool————："+jedis1.get("hgg"));
        jedis1.close();*/


        Jedis jedistest = new Jedis("192.168.133.130",6379);
        jedistest.set("test","Hello");
        System.out.println(jedistest.get("test"));
        jedistest.close();

        JedisPool jedisPool = new JedisPool("192.168.133.130",6379);
        Jedis jedis1 = jedisPool.getResource();
        jedis1.set("hgg","linux-hgg");

        System.out.println("pool————："+jedis1.get("hgg"));
        jedis1.close();

    }
}

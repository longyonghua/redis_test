package com.longge.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author longge
 * @create 2019-12-02 下午4:03
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static{
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        }catch(Exception e){
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
        jedisPool = new JedisPool(config,prop.getProperty("host"),Integer.parseInt(prop.getProperty("port")));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}

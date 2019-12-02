package com.longge.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.longge.dao.ProvinceDao;
import com.longge.dao.impl.ProvinceDaoImpl;
import com.longge.domain.Province;
import com.longge.service.ProvinceService;
import com.longge.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author longge
 * @create 2019-12-02 下午4:22
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //先从redis中查询数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String provinceJson = jedis.get("province");
        //判断是否取到了
        if(provinceJson==null || provinceJson.length()==0){
            System.out.println("redis中没数据，查询数据库..");
            List<Province> ps = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                provinceJson = mapper.writeValueAsString(ps);
            }catch(Exception e){
                e.printStackTrace();
            }
            //将json数据存入redis
            jedis.set("province",provinceJson);
            jedis.close();
        }else{
            System.out.println("redis中有数据，直接从缓存中拿..");
        }
        return provinceJson;
    }
}

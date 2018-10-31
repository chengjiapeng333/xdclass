package net.xdclass.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by chengjiapeng on 2018/9/20.
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;



    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}

package net.xdclass.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.domain.JsonData;
import net.xdclass.domain.User;
import net.xdclass.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by chengjiapeng on 2018/9/20.
 */
@RestController
@RequestMapping("/api/v1/redis")
public class RedisTestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    ObjectMapper om;

    @GetMapping(value = "add")
    public Object add() {
        return redisUtil.set("name", "xdclass")?JsonData.buildSuccess("success"):JsonData.fail("fail");
    }

    @GetMapping(value = "get")
    public Object get() {
        return JsonData.buildSuccess(redisUtil.get("name"));
    }

    @GetMapping(value = "save_user")
    public Object saveUser() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPhone("15727335610");
        user.setCreateTime(new Date());
        user.setAge(11);
        user.setPwd("123456");
/*        String userrInfo = om.writeValueAsString(user);*/
/*        System.out.println("userinfo:"+userrInfo);*/
        redisTemplate.opsForValue().set("xdclass:user:1", user.toString());
        return JsonData.buildSuccess();
    }
}

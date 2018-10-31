package net.xdclass.controller;

import net.xdclass.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chengjiapeng on 2018/9/2.
 */
@RestController
public class JsonController {

    private Map<String, Object> params = new HashMap<>();

    @GetMapping("/api/json")
    public Object testJson() {
        return new User(25,"123456", null, new Date());
    }


}

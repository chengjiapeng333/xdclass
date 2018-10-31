package net.xdclass.controller;

import net.xdclass.domain.JsonData;
import net.xdclass.domain.User;
import net.xdclass.mapper.UserMapper;
import net.xdclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by chengjiapeng on 2018/9/16.
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/add")
    public Object add() {
        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("xdclass");
        user.setPhone("15727335610");
        int id = userService.add(user);
        return new JsonData(0, id);
    }

    @GetMapping("/findAll")
    public Object findAll() {
        return JsonData.buildSuccess(userMapper.getAll());
    }

    @GetMapping("find_by_id")
    public Object findById(long id) {
        return JsonData.buildSuccess(userMapper.findById(id));
    }

    @GetMapping("del_by_id")
    public Object delById(long id) {
        userMapper.delete(id);
        return JsonData.buildSuccess();
    }

    @GetMapping("update")
    public Object update(String name, int id) {
        User user = new User();
        user.setName(name);
        user.setId(id);
        userMapper.update(user);
        return JsonData.buildSuccess();
    }

    @GetMapping("add_account")
    public Object addAccount() {
        int id = userService.addAccount();
        return JsonData.buildSuccess(id);
    }
}

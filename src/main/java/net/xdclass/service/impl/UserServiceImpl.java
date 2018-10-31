package net.xdclass.service.impl;

import net.xdclass.domain.User;
import net.xdclass.mapper.UserMapper;
import net.xdclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by chengjiapeng on 2018/9/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addAccount() {
        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("测试事务啦");
        user.setPhone("15727335610");
        userMapper.insert(user);
        int i=9/0;
        return 0;
    }
}

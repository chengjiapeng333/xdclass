package net.xdclass.controller;

import net.xdclass.domain.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chengjiapeng on 2018/9/9.
 */
@RestController
public class ExceptionController {
    @GetMapping("/api/v1/test_ext")
    public Object index() {
        int i=1/0;
        return "hello";
    }

    @GetMapping("/api/v1/myext")
    public Object myexc() {
        throw  new MyException("500", "my ext 异常");
    }
}

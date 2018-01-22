package net.coderchen.demo1.service.impl;

import net.coderchen.demo1.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by Liuyuchen on 2018/01/22.
 */
@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}

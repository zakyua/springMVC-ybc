package com.atguigu.contrillers;

import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ccstart
 * @create 2022-04-26 21:22
 */
@Controller
public class controller {

@Autowired
private UserService userService;

}

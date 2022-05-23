package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.net.http.HttpRequest;

/**
 * @author ccstart
 * @create 2022-04-26 14:08
 */
//创建对象，放入到spring的ioc容器里
@Controller
//@RequestMapping("/test")
public class HelloController {


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/test",
            method = RequestMethod.GET,
            params = {"username","password"}
            )
    public String test(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "target";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public  String testHello(){
        return "hello";
    }

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        return "succeed";
    }


    @RequestMapping("/target")
    public String target(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println(id);
        return "hello";
    }


    //使用路径中的占位符   /testRest/1/admin
    @RequestMapping("/testRest/{id}/{username}")
    public  String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){

        System.out.println(id);
        System.out.println(username);
        return "hello";
    }


}

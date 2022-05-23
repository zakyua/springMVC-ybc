package com.atguigu.controller;

import com.atguigu.bean.Book;
import com.atguigu.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ccstart
 * @create 2022-04-26 15:29
 */
@Controller
public class controller {

    @RequestMapping("/")
    public String test(){
        return  "index";
    }

    //通过servletAPI获取请求参数
    @RequestMapping("/testParam")
    public String testParam(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println(id);
        String username = request.getParameter("username");
        System.out.println(username);

        return "hello";
    }

    //通过控制器方法的形参获取请求参数(直接获取,DispatcherServlet会通过反射给形参赋值)
    @RequestMapping("/testParamDis")
    public String testParamDis(String username,Integer id){
        System.out.println(username);
        System.out.println(id);

        return "hello";
    }

    //@RequestParam是将请求参数和控制器方法的形参创建映射关系
    @RequestMapping("/testParamReq")
    public String testRequestParam(@RequestParam("id") Integer id,@RequestParam("username")String username){

        System.out.println(username);
        System.out.println(id);
        return "hello";
    }

    //通过POJO获取请求参数
    @RequestMapping("/testParamReqPojo")
    public String testUser(User user){
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        return "hello";
    }


    //通过POJO获取请求参数
    @RequestMapping(value = "/testParamReqPojo",method = {RequestMethod.POST})
    public String testUserPojo(Book book){
        System.out.println(book);
        return "hello";
    }






}
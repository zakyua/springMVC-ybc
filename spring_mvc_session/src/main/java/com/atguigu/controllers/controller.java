package com.atguigu.controllers;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ccstart
 * @create 2022-04-26 19:18
 */
@Controller
public class controller {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    //向请求域共享对象使用servletAPI
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        User user = new User(5,"陈成");
        request.setAttribute("user",user);
        return "hello";
    }

//    使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView ModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mv= new ModelAndView();
        mv.addObject("testScope", "hello,ModelAndView");
        mv.setViewName("modelAndview");
        return mv;
    }

    //使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String Model(Model model){
        model.addAttribute("testScope","hello,Model");
        return "model";
    }

    //使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String Map(Map<String,String> map){
       map.put("testScope","hello,map") ;
       return "map";
    }

//    使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap ){

        modelMap.put("testScope","hello,ModelMap");
        return "modelMap";
    }


    //向session域共享数据
    @RequestMapping("/testSessionApi")
    public String testSession(HttpSession session){
        session.setAttribute("testScope","hello,sessionAPI");
        return "hello";
    }

    //向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testScope","hello,application");
        return "hello";
    }



}

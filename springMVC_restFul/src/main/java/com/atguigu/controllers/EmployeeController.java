package com.atguigu.controllers;

import com.atguigu.bean.Employee;
import com.atguigu.bean.User;
import com.atguigu.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Collection;
import java.util.UUID;

/**
 * @author ccstart
 * @create 2022-04-27 8:34
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

  //根据请求方式的不同，实行不同的操作


    //根据get请求查询员工所有列表
    @RequestMapping(value = "/employee",method = {RequestMethod.GET})
    public String getEmployeeList(Model model){

        Collection<Employee> employeeList = employeeDAO.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employee_list";

    }


    //根据id删除员工信息
    @RequestMapping(value = "/employee/{id}",method = {RequestMethod.DELETE})
    public String delEmployee(@PathVariable("id") Integer id){
        employeeDAO.delete(id);
        return "redirect:/employee";

    }

    //添加员工信息
    @RequestMapping(value = "/employee",method = {RequestMethod.POST})
    public String addEmployee(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }

    //根据id删除员工信息
    @RequestMapping(value = "/employee/{id}",method = {RequestMethod.GET})
    public String updateEmployee(@PathVariable("id") Integer id,Model model){
       //先根据id找到这个员工
        Employee employee = employeeDAO.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";

    }

    //更新员工操作
    @RequestMapping(value = "/employee",method = {RequestMethod.PUT})
    public String updateEmployee(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }



    //获取请求体
    @RequestMapping("/testRequestBody")
    public String testRequestBody (@RequestBody String requestBody){

        System.out.println(requestBody);
        return "hello";
    }



    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("requestHeader:"+requestEntity.getHeaders());
        System.out.println("requestBody:"+requestEntity.getBody());
        return "hello";
    }



    //响应
    @RequestMapping("/testResponseBody")
    //直接将返回的字符串响应在页面上
    @ResponseBody
    public String ResponseBody(){
        return "hello";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"陈成","123456",23,"男");
    }

    //处理Ajax
    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }



    //文件下载
    @RequestMapping("/testDownLoad/{id}")
    public ResponseEntity<byte[]> testDownLoad(@PathVariable("id") Integer id, HttpSession session) throws IOException {

        //1.获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取需要下载的路径
        String fallName = "/static/img/";
        String realPath = servletContext.getRealPath(fallName + id + ".jpg");
        //创建输入流(先从服务器上输入到内存上)
        InputStream is = new FileInputStream(realPath);

        //将流读到字节数组中去
        byte[] bytes = new byte[is.available()];

        int len = is.read(bytes);

        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=+"+id+".jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        is.close();
        return responseEntity;
    }




    //文件上转
    @RequestMapping("/testDown")
    public String testDown(MultipartFile photo,HttpSession session) throws IOException {

        //获取上传的文件名
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;

        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();

        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;

        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "hello";

    }





















}

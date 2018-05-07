package com.tianyao.springbootcurd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(getClass());
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        System.out.println("coming...");
//        return "index";
//    }

    @PostMapping("/user/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"test".equals(password)){
            session.setAttribute("loginUser",username);
            logger.debug("登录成功！！！");
            return "redirect:/main.html";
        }
        map.put("msg","用户名或者密码不正确！！！");
        logger.debug("登录失败！！！");
        return "index";
    }
}

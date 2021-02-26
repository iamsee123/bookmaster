package com.example.book_management.controllers;

import com.example.book_management.biz.LogicBiz;
import com.example.book_management.model.User;
import com.example.book_management.service.UserService;
import com.example.book_management.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/*
    @author Tktim
 */
@Controller
public class LogininController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogicBiz logicBiz;

    @RequestMapping(path = {"/users/register"},method = {RequestMethod.GET})
    public String register(){
        return "login/register";
    }

    @RequestMapping(path = {"/users/register/do"},method = {RequestMethod.POST})
    public String doRegister(
            Model model,
            HttpServletResponse response,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        try{
            String ticket = logicBiz.register(user);
            CookieUtil.writeCookie("ticket",ticket,response);
            return "redirect:/index";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "404";
        }
    }

    @RequestMapping(path = {"/user/login"},method = {RequestMethod.GET})
    public String login(){
        return "/login/login";
    }

    @RequestMapping(path = {"/user/login/do"},method = {RequestMethod.POST})
    public String doLogin(
            Model model,
            HttpServletResponse response,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        try {
            String ticket = logicBiz.login(email,password);
            CookieUtil.writeCookie("ticket",ticket,response);
            return "redirect:/index";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "404";
        }
    }

    @RequestMapping(path = {"/user/logout/do"},method = RequestMethod.POST)
    public String doLogout(
            @CookieValue("ticket") String ticket
    ){
        logicBiz.logout(ticket);
        return "redirect:/index";
    }

}

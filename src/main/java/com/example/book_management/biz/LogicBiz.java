package com.example.book_management.biz;

import com.example.book_management.mapper.TicketDAO;
import com.example.book_management.model.Ticket;
import com.example.book_management.model.User;
import com.example.book_management.model.expection.LoginRegisterExpection;
import com.example.book_management.service.TicketService;
import com.example.book_management.service.UserService;
import com.example.book_management.util.ConcurrentUtil;
import com.example.book_management.util.MD5;
import com.example.book_management.util.TicketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.security.auth.login.LoginException;
import java.rmi.server.ExportException;
import java.time.LocalDateTime;

/*
    @author Tktim
 */
@Service
public class LogicBiz {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;

    /**
     * 先检查登陆邮箱和密码，然后更新票
     * @return 返回最新的票
     * @throws Exception 账号密码错误
     */
    public String login(String email,String password) throws Exception{
        User user = userService.getUser(email);

        //登陆用户检查
        if(user == null){
            throw new LoginRegisterExpection("邮箱不存在");
        }
        if(!StringUtils.equals(MD5.generate(password),user.getPassword())){
            throw new LoginRegisterExpection("密码错误");
        }

        //检查票
        Ticket ticket = ticketService.getTicket(user.getId());
        //没有票则生成一个
        if(ticket == null){
            ticket = TicketUtil.next(user.getId());
            ticketService.addTicket(ticket);
            return ticket.getTicket();
        }
        //是否过期
        if(ticket.getExpireDate().isBefore(LocalDateTime.now())){
            ticketService.deleteTicket(ticket.getId());
        }
        //有票，没过期更新一下
        ticket = TicketUtil.next(user.getId());
        ticketService.addTicket(ticket);
        ConcurrentUtil.setHost(user);
        return ticket.getTicket();
    }
    /**
     * 退出登陆，删除票
     */
    public void logout(String t){
        ticketService.deleteTicket(t);
    }
    /**
     * 注册新用户，返回对应的票
     * @return 新建的票
     */
    public String register(User user) throws Exception{
        //检查是否已经存在用户
        if(userService.getUser(user.getId()) != null){
            throw new LoginRegisterExpection("用户已经存在");
        }
        //密码加密
        String userPassword = user.getPassword();
        String encryptPassword = MD5.generate(userPassword);
        user.setPassword(encryptPassword);
        //添加新用户
        userService.addUser(user);
        //新建票
        Ticket ticket = TicketUtil.next(user.getId());
        //添加票
        ticketService.addTicket(ticket);
        ConcurrentUtil.setHost(user);
        return ticket.getTicket();
    }
}

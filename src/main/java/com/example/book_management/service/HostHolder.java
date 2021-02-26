package com.example.book_management.service;

import com.example.book_management.model.User;
import com.example.book_management.util.ConcurrentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostHolder {
    public User getUser(){
       return ConcurrentUtil.getHost();
    }
    public void setUser(User user){
        ConcurrentUtil.setHost(user);
    }
}

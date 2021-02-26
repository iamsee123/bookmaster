package com.example.book_management.util;

import com.example.book_management.model.User;
/*
    @author Tktim
    存储访问者的信息，以便在程序的任何地方取出User信息
 */
public class ConcurrentUtil {
    private static ThreadLocal<User> host = new ThreadLocal<>();
    public static User getHost(){
        return host.get();
    }
    public static void setHost(User user){
        host.set(user);
    }
}

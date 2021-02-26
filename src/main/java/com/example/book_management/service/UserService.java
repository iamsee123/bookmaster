package com.example.book_management.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.book_management.model.User;
import com.example.book_management.mapper.UserDAO;
import org.springframework.stereotype.Service;
/*
    @author Tktim
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public int addUser(User user){
        return userDAO.addUser(user);
    }

    public User getUser(int uid){
        return userDAO.selectById(uid);
    }

    public User getUser(String email){
        return userDAO.selectByEmail(email);
    }
}

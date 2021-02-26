package com.example.book_management.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.book_management.model.User;

@Mapper
public interface UserDAO {
    public int addUser(User user);
    public User selectById(int id);
    public User selectByName(String name);
    public User selectByEmail(String email);
    void updatePassword(User user);
}

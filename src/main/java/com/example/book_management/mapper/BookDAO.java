package com.example.book_management.mapper;

import com.example.book_management.model.Book;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface BookDAO {

    List<Book> findAll();
    int addBook(Book book);
    void updateBook(int id,int status);

}

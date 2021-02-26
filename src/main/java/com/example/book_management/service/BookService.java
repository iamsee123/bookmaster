package com.example.book_management.service;
/*
    @author Tktim
 */
import com.example.book_management.model.Book;
import com.example.book_management.mapper.BookDAO;
import com.example.book_management.model.enums.BookStatusEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks(){
        return bookDAO.findAll();
    }
    public int addBooks(Book book){
        return bookDAO.addBook(book);
    }
    public void deleteBooks(int id){
        bookDAO.updateBook(id,BookStatusEnum.DELETE.getValue());
    }
    public void recoverBooks(int id){
        bookDAO.updateBook(id,BookStatusEnum.NORMAL.getValue());
    }
}

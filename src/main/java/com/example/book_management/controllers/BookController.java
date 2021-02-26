package com.example.book_management.controllers;

import com.example.book_management.model.Book;
import com.example.book_management.model.User;
import com.example.book_management.service.BookService;
import com.example.book_management.service.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
    @author Tktim
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private HostHolder hostHolder;

    private void loadAllBooks(Model model){
        model.addAttribute("books",bookService.getAllBooks());
    }
    @RequestMapping(path = {"/index"},method = RequestMethod.GET)
    public String bookList(Model model){
        User host = hostHolder.getUser();
        if(host != null){
            model.addAttribute("host",host);
        }
        loadAllBooks(model);
        return "book/books";
    }

    @RequestMapping(path = {"/books/add"},method = RequestMethod.GET)
    public String addBook(){
        return "book/addbook";
    }

    @RequestMapping(path = {"/books/add/do"},method = RequestMethod.POST)
    public String doAddBook(
            @RequestParam("name") String name,
            @RequestParam("author") String author,
            @RequestParam("price") String price
    ){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        bookService.addBooks(book);
        return "redirect:/index";
    }

    @RequestMapping(path = {"/books/{bookId:[0-9]+}/delete"},method = RequestMethod.POST)
    public String deleteBook(
            @RequestParam("bookId") int bookId
    ){
        bookService.deleteBooks(bookId);
        return "redirect:/index";
    }

    @RequestMapping(path = {"/books/{bookId:[0-9]+}/recover"},method = RequestMethod.POST)
    public String recoverBook(
            @RequestParam("bookId") int bookId
    ){
        bookService.recoverBooks(bookId);
        return "redirect:/index";
    }



}

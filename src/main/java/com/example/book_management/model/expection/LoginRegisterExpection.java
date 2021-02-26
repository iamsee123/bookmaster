package com.example.book_management.model.expection;
/*
    @author Tktim
 */
public class LoginRegisterExpection extends RuntimeException {
    public LoginRegisterExpection(){
        super();
    }
    public LoginRegisterExpection(String message){
        super(message);
    }
    public LoginRegisterExpection(String messager,Throwable cause){
        super(messager,cause);
    }
    public LoginRegisterExpection(Throwable cause){
        super(cause);
    }
}

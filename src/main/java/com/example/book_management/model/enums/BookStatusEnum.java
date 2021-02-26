package com.example.book_management.model.enums;
/*
    @author Tktim
 */
public enum BookStatusEnum {

    NORMAL(0),
    DELETE(1),
    RECOMMENDED(2),
    ;

    private int value;
    private BookStatusEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}

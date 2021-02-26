package com.example.book_management.util;

import java.util.UUID;
/*
    @author Tktim
 */
public class uuidUtil {
    public static String getUUid(){
        return UUID.randomUUID().toString().replace("-","a");
    }
}

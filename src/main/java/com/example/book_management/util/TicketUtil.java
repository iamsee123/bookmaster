package com.example.book_management.util;

import com.example.book_management.model.Ticket;

import java.time.LocalDateTime;


/*
    @author Tktim
 */
public class TicketUtil {
    public static Ticket next(int uid){
        Ticket ticket = new Ticket();
        ticket.setTicket(uuidUtil.getUUid());
        ticket.setId(uid);
        //设置过期时间
        LocalDateTime expiredTime = LocalDateTime.now();
        expiredTime = expiredTime.plusMonths(3);
        ticket.setExpireDate(expiredTime);
        return ticket;
    }
}

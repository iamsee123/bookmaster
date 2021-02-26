package com.example.book_management.mapper;

import com.example.book_management.model.Ticket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketDAO {
    public int addTicket(Ticket ticket);
    Ticket selectByUserId(int uid);
    Ticket selectByTicket(String t);
    void deleteTicketById(int id);
    void deleteTicketByTicket(String t);
}

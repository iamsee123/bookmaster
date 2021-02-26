package com.example.book_management.service;
import com.example.book_management.mapper.TicketDAO;
import com.example.book_management.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
    @author Tktim
 */
@Service
public class TicketService {
    @Autowired
    private TicketDAO ticketDAO;
    public void addTicket(Ticket t){
        ticketDAO.addTicket(t);
    }
    public Ticket getTicket(int uid){
        return ticketDAO.selectByUserId(uid);
    }
    public Ticket getTicket(String t){
        return ticketDAO.selectByTicket(t);
    }
    public void deleteTicket(int id){
        ticketDAO.deleteTicketById(id);
    }
    public void deleteTicket(String t){
        ticketDAO.deleteTicketByTicket(t);
    }
}

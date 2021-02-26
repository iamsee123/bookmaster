package com.example.book_management.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
    @author Tktim
    Ticket entity
    login in information to make sure who you are
 */
public class Ticket {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    private int id;
    private int userId;
    private String ticket;
    private LocalDateTime expireDate;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticket='" + ticket + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }
}

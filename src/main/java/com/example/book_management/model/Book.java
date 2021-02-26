package com.example.book_management.model;

import org.springframework.cloud.client.loadbalancer.LoadBalancerProperties;

/*
    @author Tktim
    21/2/2021  23:24
    sql book table
 */
public class Book {

    private int id;
    private String name;
    private String author;
    private String price;
    private int status;

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;};

    public String getAuthor(){return author;}

    public void setAuthor(String author){this.author = author;}

    public String getPrice(){return price;}

    public void setPrice(String price){this.price = price;}

    public int getStatus(){return status;}

    public void setStatus(int status){this.status = status;}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", status=" + status +
                '}';
    }
}

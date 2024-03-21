package com.ttp.inventory.model;

public class Book
{
    private int bookId;
    private String bookName;
    private String author;
    private String publication;
    private int quantity;
    private double price;
    private String category;

    public Book(int bookId, String bookName, String author, String publication, int quantity, double price, String category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publication = publication;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

package com.example.segundoexamenparcial;

import java.util.Objects;

public class Book {
    String title;
    String author;
    String editorial;
    String description;
    String price;
    String url_image;

    public Book(String title, String author, String editorial, String description, String price, String url_image) {
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.description = description;
        this.price = price;
        this.url_image = url_image;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "\n\nBook{\n" +
                "\t\ttitle='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", url_image='" + url_image + '\'' +
                "\n}\n\n";
    }
}
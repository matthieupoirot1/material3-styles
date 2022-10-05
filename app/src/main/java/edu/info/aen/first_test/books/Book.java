package edu.info.aen.first_test.books;

public class Book {
    private String title;
    private String author;
    private float note;

    public Book(String title, String author, float note) {
        this.title = title;
        this.author = author;
        this.note = note;
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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}

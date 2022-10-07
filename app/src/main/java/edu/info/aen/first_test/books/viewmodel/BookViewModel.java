package edu.info.aen.first_test.books.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.info.aen.first_test.books.Book;

public class BookViewModel extends ViewModel {
    private List<Book> books = new ArrayList<Book>();
    Book lastModifiedBook = null;

    /**
     * Add a book to the list
     * @param book
     * @return the position of the added Book
     */
    public int addBook(Book book) {
        books.add(book);
        return this.books.size() - 1;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book getBook(int position){
        return this.books.get(position);
    }

    public List<Book> getBooks() {
        if(this.books.size()<=0) initBooks();
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private void initBooks(){
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 2.5F));
        books.add(new Book("Royal Assassin", "Robin HOBB", 5));
        books.add(new Book("Fablehaven", "Brandon Mull", 3.8F));
    }

    public void updateModifiedBook(Book book){
        this.lastModifiedBook = book;
    }

    public Book getModifiedBook(){
        return this.lastModifiedBook;
    }
}

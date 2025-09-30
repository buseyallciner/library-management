package com.buse.library.repo;
import com.buse.library.model.Book;
import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books= new ArrayList<>();
    private int nextId=1;

    public Book addBook(String title,String author){
        Book book=new Book(nextId++,title,author);
        books.add(book);
        return book;
    }

    public ArrayList<Book> listBooks(){
        return books;
    }

    public boolean borrowBook(int id){
        for(Book b:books){
            if(b.getId()==id){
                if(b.isAvailable()){
                    b.setAvailable(false);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public boolean returnBook(int id){
        for(Book b:books){
            if(b.getId()==id){
                if(!b.isAvailable()){
                    b.setAvailable(true);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}


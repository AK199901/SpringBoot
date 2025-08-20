package com.example.Library_system.Service;

import com.example.Library_system.DTO.BookWithDetailsDTO;
import com.example.Library_system.Entity.Book;
import com.example.Library_system.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService  {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Book createBook(Book book)
    {
        return bookRepository.save(book);
    }


}

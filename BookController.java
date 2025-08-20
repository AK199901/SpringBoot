package com.example.Library_system.Controller;


import com.example.Library_system.Entity.*;
import com.example.Library_system.Repository.BookRepository;

import com.example.Library_system.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> books = bookService.getAllBooks().stream().toList();
        return  ResponseEntity.ok(books);
    }


    @GetMapping("/test")
    public String test() {
        return "Spring Boot is running!";
    }

    @GetMapping("/test/database")
    public Map<String, Object> testDatabase() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Database connection successful!");
        result.put("book_count", bookRepository.count());
        return result;
    }
}

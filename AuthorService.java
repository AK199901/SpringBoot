package com.example.Library_system.Service;

import com.example.Library_system.Entity.Author;
import com.example.Library_system.Entity.Book;
import com.example.Library_system.Repository.AuthorRepository;
import com.example.Library_system.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService  {
    private final AuthorRepository AuthorRepository;

    @Autowired

    public AuthorService(AuthorRepository authorRepository) {
        AuthorRepository = authorRepository;
    }


    public List<Author> getAllBooks()
    {
        return AuthorRepository.findAll();
    }
    //CRUD Create ..remove ..update ...display
    public Author createBook(Author author)
    {
        return AuthorRepository.save(author);
    }
}
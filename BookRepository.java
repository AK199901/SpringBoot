package com.example.Library_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.Library_system.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}

package com.example.Library_system.Entity;

// src/main/java/com/example/librarysystem/entity/Book.java

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authors")  // Måste matcha tabellnamnet i databasen
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "INTEGER")
    private long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String first_name;

    @Column (name = "last_name")
    private String last_name;

    @Column (name = "birth_year")
    private Integer birth_year;

    @Column (name = "nationality")
    private String nationality;

    public Author() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

}


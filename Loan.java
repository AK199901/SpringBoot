package com.example.Library_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Loan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (optional = false)
    private User user;
    @ManyToOne (optional = false)
    private Book book;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

}

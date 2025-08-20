package com.example.Library_system.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data

public class LoanDTO {

    private Long id;
    private Long userId;
    private Long bookId;
    private String bookTitle;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;
}

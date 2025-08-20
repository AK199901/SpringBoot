package com.example.Library_system.Controller;

import com.example.Library_system.DTO.LoanDTO;
import com.example.Library_system.Service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    public LoanController(LoanService loanService) { this.loanService = loanService; }

    @PostMapping("/borrow")
    public LoanDTO borrow(@RequestParam Long userId, @RequestParam Long bookId) {
        return loanService.borrow(userId, bookId);
    }

    @PostMapping("/return/{loanId}")
    public LoanDTO returnBook(@PathVariable Long loanId) {
        return loanService.returnBook(loanId);
    }

    @GetMapping("/active")
    public List<LoanDTO> activeByUser(@RequestParam Long userId) {
        return loanService.activeLoansForUser(userId);
    }
}
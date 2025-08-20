package com.example.Library_system.Service;

import com.example.Library_system.DTO.LoanDTO;
import com.example.Library_system.Entity.Book;
import com.example.Library_system.Entity.Loan;
import com.example.Library_system.Entity.User;
import com.example.Library_system.Repository.BookRepository;
import com.example.Library_system.Repository.LoanRepository;
import com.example.Library_system.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LoanService(LoanRepository loanRepository,
                       BookRepository bookRepository,
                       UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public LoanDTO borrow(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("Book not available");
        }


        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(14));
        loan.setReturned(false);

        loan = loanRepository.save(loan);
        return mapToDTO(loan);
    }

    public LoanDTO returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.isReturned()) {
            return mapToDTO(loan);
        }

        loan.setReturned(true);
        loanRepository.save(loan);


        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        return mapToDTO(loan);
    }

    public List<LoanDTO> activeLoansForUser(Long userId) {
        return loanRepository.findByUserIdAndReturnedFalse(userId)
                .stream().map(this::mapToDTO).toList();
    }

    private LoanDTO mapToDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setUserId(loan.getUser().getId());
        dto.setBookId(loan.getBook().getId());
        dto.setBookTitle(loan.getBook().getTitle());
        dto.setLoanDate(loan.getLoanDate());
        dto.setDueDate(loan.getDueDate());
        dto.setReturned(loan.isReturned());
        return dto;
    }
}

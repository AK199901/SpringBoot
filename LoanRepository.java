package com.example.Library_system.Repository;
import com.example.Library_system.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserIdAndReturnedFalse(Long userId);
}

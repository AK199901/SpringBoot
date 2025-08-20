package com.example.Library_system.Repository;

import com.example.Library_system.Entity.User;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

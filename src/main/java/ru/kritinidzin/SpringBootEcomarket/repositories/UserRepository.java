package ru.kritinidzin.SpringBootEcomarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kritinidzin.SpringBootEcomarket.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

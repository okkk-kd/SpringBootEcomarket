package ru.kritinidzin.SpringBootEcomarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.kritinidzin.SpringBootEcomarket.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    Optional<Product> findById(@Param("id")Long id);
    List<Product> findByCategory(String name);

    List<Product> findByPrice(double price);
}

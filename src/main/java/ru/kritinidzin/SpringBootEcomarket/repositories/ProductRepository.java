package ru.kritinidzin.SpringBootEcomarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kritinidzin.SpringBootEcomarket.models.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByCategory(String name);

    List<Product> findByPrice(double price);
}

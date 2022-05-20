package ru.kritinidzin.SpringBootEcomarket.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kritinidzin.SpringBootEcomarket.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

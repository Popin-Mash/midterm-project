package com.example.midtermproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.midtermproject.models.Category;
import com.example.midtermproject.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByStatus(String status);

    List<Category> findAllByStockType(String status);

}

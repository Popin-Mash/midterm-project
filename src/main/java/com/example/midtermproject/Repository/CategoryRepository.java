package com.example.midtermproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.midtermproject.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByStatusInOrderByIdDesc(List<String> list);

    List<Category> findAllByStatus(String status);

}

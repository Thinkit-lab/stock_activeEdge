package com.exercise.active_edge.exercise3.repository;

import com.exercise.active_edge.exercise3.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByName(String name);
}

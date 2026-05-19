package com.GameHubStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GameHubStore.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

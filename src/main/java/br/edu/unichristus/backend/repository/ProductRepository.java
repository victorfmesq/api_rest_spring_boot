package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}

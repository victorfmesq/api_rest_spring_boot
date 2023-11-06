package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Optional<Product> findByName(String Name);
}

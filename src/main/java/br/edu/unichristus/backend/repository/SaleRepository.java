package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}

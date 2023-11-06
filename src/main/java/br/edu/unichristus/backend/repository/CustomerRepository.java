package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  // TODO: verificar se funciona
  Optional<Customer> findByCpf(String cpf);
}

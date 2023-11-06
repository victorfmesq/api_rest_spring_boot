package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.converter.DozerConverter;
import br.edu.unichristus.backend.data.dto.CustomerDTO;
import br.edu.unichristus.backend.data.dto.CustomerLowDTO;
import br.edu.unichristus.backend.data.model.Customer;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.CustomerRepository;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository repository;

  public CustomerDTO save(CustomerDTO dto) {
    if (dto.getName().length() > 100) {
      throw new CommonsException(HttpStatus.BAD_REQUEST,
          "unichristus.backend.service.customer.badrequest.exception",
          "O nome do cliente excede o limite de 100 caracteres.");
    }

    if (dto.getCpf().length() > 11) {
      throw new CommonsException(HttpStatus.BAD_REQUEST,
          "unichristus.backend.service.customer.badrequest.exception",
          "O cpf do cliente excede o limite de 11 caracteres.");
    }

    if (!repository.findByCpf(dto.getCpf()).isEmpty()) {
      throw new CommonsException(HttpStatus.CONFLICT,
          "unichristus.backend.service.customer.conflict.exception",
          "O cpf informado ja foi cadastrado.");
    }

    if (dto.getId() != null) {
      this.findById(dto.getId());
    }

    var customer = DozerConverter.parseObject(dto, Customer.class);
    var returnCustomer = DozerConverter.parseObject(repository.save(customer), CustomerDTO.class);

    return returnCustomer;
  }

  public void delete(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

  public CustomerLowDTO findById(Long id) {
    var customer = repository.findById(id);

    if (customer == null || customer.isEmpty()) {
      throw new CommonsException(HttpStatus.NOT_FOUND,
          "unichristus.backend.service.customer.notfound.exception",
          "Cliente não encontrado.");
    }

    var returnCustomer = DozerConverter.parseObject(customer.get(), CustomerLowDTO.class);

    return returnCustomer;
  }

  public List<CustomerLowDTO> findAll() {
    return DozerConverter.parseListObjects(repository.findAll(), CustomerLowDTO.class);
  }
}

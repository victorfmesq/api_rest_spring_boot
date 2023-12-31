package br.edu.unichristus.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.CustomerDTO;
import br.edu.unichristus.backend.data.dto.CustomerLowDTO;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

  @Autowired
  private CustomerService service;

  @Operation(summary = "Cadastra os dados de um cliente | role: [ADMIN]", tags = "Customer")
  @PostMapping
  public CustomerDTO create(@RequestBody CustomerDTO customer) {
    if (customer.getId() != null) {
      throw new CommonsException(HttpStatus.BAD_REQUEST,
          "unichristus.backend.controller.customer.badrequest.exception",
          "O campo Id não é permitido nesta rota.");
    }
    return service.save(customer);
  }

  @Operation(summary = "Altera os dados de um cliente | role: [ADMIN]", tags = "Customer")
  @PutMapping("/{id}")
  public CustomerDTO update(@RequestBody CustomerDTO customer, @PathVariable("id") Long id) {
    customer.setId(id);
    return service.save(customer);
  }

  @Operation(summary = "Retorna os dados de um cliente | role: [ADMIN]", tags = "Customer")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "cliente retornado com sucesso"),
      @ApiResponse(responseCode = "404", description = "cliente não encontrado"),
      @ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
  @GetMapping("/{id}")
  public CustomerLowDTO findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @Operation(summary = "Remove um cliente através do ID | role: [ADMIN]", tags = "Customer")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    service.delete(id);
  }

  @Operation(summary = "Retorna os dados de todos os clientes | role: [ADMIN]", tags = "Customer")
  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}

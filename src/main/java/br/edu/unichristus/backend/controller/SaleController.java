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

import br.edu.unichristus.backend.data.dto.SaleDTO;
import br.edu.unichristus.backend.data.dto.SaleLowDTO;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/sale")
public class SaleController {

  @Autowired
  private SaleService service;

  @Operation(summary = "Cadastra os dados de uma venda | role: [ADMIN]", tags = "Sale")
  @PostMapping
  public SaleDTO create(@RequestBody SaleDTO Sale) {
    if (Sale.getId() != null) {
      throw new CommonsException(HttpStatus.BAD_REQUEST,
          "unichristus.backend.controller.sale.badrequest.exception",
          "O campo Id não é permitido nesta rota.");
    }

    return service.save(Sale);
  }

  @Operation(summary = "Altera os dados de uma venda | role: [ADMIN]", tags = "Sale")
  @PutMapping("/{id}")
  public SaleDTO update(@RequestBody SaleDTO Sale, @PathVariable("id") Long id) {
    Sale.setId(id);
    return service.save(Sale);
  }

  @Operation(summary = "Retorna os dados de uma venda | role: [ADMIN]", tags = "Sale")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Venda retornada com sucesso"),
      @ApiResponse(responseCode = "404", description = "Venda não encontrada"),
      @ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
  @GetMapping("/{id}")
  public SaleLowDTO findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @Operation(summary = "Remove uma venda através do ID | role: [ADMIN]", tags = "Sale")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    service.delete(id);
  }

  @Operation(summary = "Retorna os dados de todos as vendas | role: [ADMIN]", tags = "Sale")
  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}

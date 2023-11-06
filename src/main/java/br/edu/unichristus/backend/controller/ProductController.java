package br.edu.unichristus.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.ProductDTO;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

  @Autowired
  private ProductService service;

  @Operation(summary = "Cadastra os dados de um produto ", tags = "Product")
  @PostMapping
  public ProductDTO create(@RequestBody ProductDTO product) {
    if (product.getId() != null) {
      throw new CommonsException(HttpStatus.BAD_REQUEST,
          "unichristus.backend.controller.product.badrequest.exception",
          "O campo Id não é permitido nesta rota.");
    }
    return service.save(product);
  }

  @Operation(summary = "Atualiza os dados de um produto ", tags = "Product")

  @PutMapping("/{id}")
  public ProductDTO update(@RequestBody ProductDTO product, @PathParam(value = "id") Long id) {
    product.setId(id);
    return service.save(product);
  }

  @Operation(summary = "Remove os dados de um produto", tags = "Product")

  @DeleteMapping
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }

  @Operation(summary = "Retorna os dados de um produto", tags = "Product")

  @GetMapping("/{id}")
  public ProductDTO findById(@PathParam("id") Long id) {
    return service.findById(id);
  }

  @Operation(summary = "Retorna os dados de todos os produtos", tags = "Product")
  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

}

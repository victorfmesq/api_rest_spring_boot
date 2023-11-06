package br.edu.unichristus.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.ProductDTO;
import br.edu.unichristus.backend.service.ProductService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

  @Autowired
  private ProductService service;

  @PostMapping
  public ProductDTO create(@RequestBody ProductDTO product) {
    return service.save(product);
  }

  @PutMapping
  public ProductDTO update(@RequestBody ProductDTO product) {
    return service.save(product);
  }

  @DeleteMapping
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }

  @GetMapping("/{id}")
  public ProductDTO findById(@PathParam("id") Long id) {
    return service.findById(id);
  }

  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

}

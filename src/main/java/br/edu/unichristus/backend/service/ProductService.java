package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.converter.DozerConverter;
import br.edu.unichristus.backend.data.dto.ProductDTO;
import br.edu.unichristus.backend.data.model.Product;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public ProductDTO save(ProductDTO dto) {
    if (dto.getName().length() > 100) {
      throw new CommonsException(HttpStatus.BAD_REQUEST, // 400
          "unichristus.backend.service.product.badrequest.exception",
          "O nome do produto excede o limite de 100 caracteres.");
    }

    var prodId = dto.getId();

    if (prodId != null) {
      this.findById(prodId);
    }

    var product = DozerConverter.parseObject(dto, Product.class);

    var returnProject = DozerConverter.parseObject(repository.save(product), ProductDTO.class);

    return returnProject;
  }

  public void delete(long id) {
    this.findById(id);
    repository.deleteById(id);
  }

  public ProductDTO findById(Long id) {
    var product = repository.findById(id);

    if (product.isEmpty() || product == null) {
      throw new CommonsException(HttpStatus.NOT_FOUND,
          "unichristus.backend.service.product.notfound.exception",
          "Producto não encontrado.");
    }

    var returnProject = DozerConverter.parseObject(product.get(), ProductDTO.class);

    return returnProject;

  }

  public List<Product> findAll() {
    return repository.findAll();
  }
}

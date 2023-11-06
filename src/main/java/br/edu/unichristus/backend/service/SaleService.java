package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.converter.DozerConverter;
import br.edu.unichristus.backend.data.dto.SaleDTO;
import br.edu.unichristus.backend.data.dto.SaleLowDTO;
import br.edu.unichristus.backend.data.model.Sale;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.SaleRepository;

@Service
public class SaleService {

  @Autowired
  private SaleRepository repository;

  @Autowired
  private CustomerService customerService;
  @Autowired
  private ProductService productService;

  public SaleDTO save(SaleDTO dto) {
    var saleId = dto.getId();

    if (saleId != null) {
      this.findById(saleId);
    }

    // validate customer
    customerService.findById(dto.getCustomerId());

    // validate product
    dto.getProducts().forEach(product -> productService.findById(product.getId()));

    var sale = DozerConverter.parseObject(dto, Sale.class);
    var returnSale = DozerConverter.parseObject(repository.save(sale), SaleDTO.class);

    return returnSale;
  }

  public void delete(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

  public SaleLowDTO findById(Long id) {
    var sale = repository.findById(id);

    if (sale == null || sale.isEmpty()) {
      throw new CommonsException(HttpStatus.NOT_FOUND,
          "unichristus.backend.service.user.notfound.exception",
          "Usuário não encontrado.");
    }

    var returnUser = DozerConverter.parseObject(sale.get(), SaleLowDTO.class);

    return returnUser;
  }

  public List<SaleLowDTO> findAll() {
    return DozerConverter.parseListObjects(repository.findAll(), SaleLowDTO.class);
  }
}

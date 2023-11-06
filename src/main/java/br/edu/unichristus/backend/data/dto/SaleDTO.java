package br.edu.unichristus.backend.data.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
  private Long id;
  private Date saleDate;
  private List<ProductDTO> products;
  private Long customerId;
}

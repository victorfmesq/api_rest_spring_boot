package br.edu.unichristus.backend.data.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleLowDTO {
  private Date saleDate;
  private float total;
  private List<ProductDTO> products;
  private Long customerId;
}

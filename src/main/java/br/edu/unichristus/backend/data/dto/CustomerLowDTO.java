package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLowDTO {
  private String Name;
  private String Cpf;
}

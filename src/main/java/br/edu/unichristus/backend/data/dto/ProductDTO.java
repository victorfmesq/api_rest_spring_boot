package br.edu.unichristus.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
  @JsonIgnore
  private Long Id;
  private String Name;
  private float Value;
}

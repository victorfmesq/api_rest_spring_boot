package br.edu.unichristus.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLowDTO {

  @JsonProperty("nome") // muda o nome do atributo abaixo retornado no Json de resposta
  private String name;
  private String email;
  private String login;
}

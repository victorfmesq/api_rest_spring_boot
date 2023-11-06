package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private Long id;
  private String name;
  private String email;
  private String login;
  private String password;
}

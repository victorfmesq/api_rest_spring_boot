package br.edu.unichristus.backend.data.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// serializable

/* metodo para trasnferir objetos entre computadors. Basicamente ele ao inves de passar a referencia de memória.
  trasnforma o objeto em binario.

  sempre que retoranr algo da api p fora deve ser um serializable
*/

@Data
@AllArgsConstructor // criar todos os contrutores padrão
@NoArgsConstructor // criar construtor vazio
@JsonPropertyOrder({"message", "key"}) // define a ordem dos atributos que o JSON retorna. Default = ordem que for escrito 
public class MessageDTO implements Serializable{
  private static final long serialVersionUID = 1L;

  private String message;
  private String key;
}

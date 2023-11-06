package br.edu.unichristus.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.unichristus.backend.data.dto.MessageDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data // gera hashcodeEquals de todas as ramificações da classe atual (problema do Lombok)
@EqualsAndHashCode(callSuper = false) // pra ele não fazer o que é descrito acima passamo este argumentos
@Builder
@AllArgsConstructor // cria um construtor com todos os atributos
public class CommonsException extends RuntimeException { // Exceções que ocorrem em tempo de execução
    private static final long serialVersionUID = -4694258578216919456L;
    protected HttpStatus status;
    protected String key;
    protected String text;

    public ResponseEntity<MessageDTO> getMessageError() {
    // Remodulando a saida passando status e a mensagens
    return ResponseEntity.status(status).body(new MessageDTO(text, key));
}
}

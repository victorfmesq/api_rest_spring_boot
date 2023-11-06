package br.edu.unichristus.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

import br.edu.unichristus.backend.converter.DozerConverter;
import br.edu.unichristus.backend.data.dto.UserDTO;
import br.edu.unichristus.backend.data.dto.UserLowDTO;
import br.edu.unichristus.backend.data.model.User;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public UserDTO save(UserDTO dto) {
    var userId = dto.getId();

    if (userId != null) { // id
      this.findById(userId);
    }

    if (dto.getName().length() > 100) { // userName
      throw new CommonsException(HttpStatus.BAD_REQUEST, // 400
          "unichristus.backend.service.user.badrequest.exception",
          "O nome do usuário excede o limite de 100 caracteres.");
    }

    var userByEmail = repository.findByEmail(dto.getEmail());

    if (!userByEmail.isEmpty() && userByEmail.get().getId() != userId) { // email
      throw new CommonsException(HttpStatus.CONFLICT, // 409
          "unichristus.backend.service.user.conflict.exception",
          "O email informado ja foi cadastrado.");
    }

    var userByLogin = repository.findByLogin(dto.getLogin());

    if (!userByLogin.isEmpty() && userByLogin.get().getId() != userId) { // login
      throw new CommonsException(HttpStatus.CONFLICT, // 409
          "unichristus.backend.service.user.conflict.exception",
          "O login informado não existe.");
    }

    // conversão do dto para o objeto recebido pelo banco
    var user = DozerConverter.parseObject(dto, User.class);

    // conversao do retorno do salve(user) para o DTO de retorno
    var returnUser = DozerConverter.parseObject(repository.save(user), UserDTO.class);

    return returnUser;
  }

  public void delete(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

  public UserLowDTO findById(Long id) {
    var user = repository.findById(id);

    if (user == null || user.isEmpty()) {
      throw new CommonsException(HttpStatus.NOT_FOUND,
          "unichristus.backend.service.user.notfound.exception",
          "Usuário não encontrado.");
    }

    var returnUser = DozerConverter.parseObject(user.get(), UserLowDTO.class);

    return returnUser;
  }

  public List<UserLowDTO> findAll() {
    return DozerConverter.parseListObjects(repository.findAll(), UserLowDTO.class);
  }
}

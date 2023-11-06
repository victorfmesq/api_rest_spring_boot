package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	// Optional é como um Maybe no C#
	Optional <User> findByEmail(String email);

	// @Query(value = "Select * FROM ...", nativeQuery = true) diz que o metodo fará tal consulta no banco e que é uma consulta nativa do banco conectado
	Optional <User> findByLogin(String login);

}

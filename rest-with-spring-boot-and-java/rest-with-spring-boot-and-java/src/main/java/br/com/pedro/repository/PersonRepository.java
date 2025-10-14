package br.com.pedro.repository;

import br.com.pedro.services.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//Classe criada para acessar as operações CRUD!
//Para ter acesso as operações a classe repository necessita estender o JpaRepository!
//Ao passar os parãmetros para interface o primeiro será o Tipo (Person),
//o segundo será o id da entidade (Long).
public interface PersonRepository extends JpaRepository<Person, Long> {}

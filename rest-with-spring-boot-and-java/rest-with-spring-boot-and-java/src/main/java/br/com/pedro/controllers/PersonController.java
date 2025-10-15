package br.com.pedro.controllers;

import br.com.pedro.services.PersonServices;
import br.com.pedro.services.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Marca a classe como um Controlador Rest
@RequestMapping("/person")
public class PersonController {

    @Autowired //Injeção de dependência do Spring
    private PersonServices service;

    @GetMapping( // Como não estou passando um parâmetro ele irá para o default,
      // que será o findAll, se eu passar um parâmetro ele irá para o findById (SE FOR UM GET).
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll (){
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE
    )//O produces garante que o retorno será em formato JSON.
    public Person findById (@PathVariable("id") Long id){
       return service.findById(id);
    }

    @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE, //Consome uma aplicação JSON.
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create (@RequestBody//Irá pegar o valores passador no Person
                              Person person){
       return service.create(person);
    }

 @PutMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE, //Consome uma aplicação JSON.
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update (@RequestBody
                              Person person){
       return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
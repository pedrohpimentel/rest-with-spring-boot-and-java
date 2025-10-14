package br.com.pedro.controllers;

import br.com.pedro.services.PersonServices;
import br.com.pedro.services.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Marca a classe como um Controlador Rest
@RequestMapping("/person")
public class PersonController {

    @Autowired //Injeção de dependência do Spring
    private PersonServices service;

    @RequestMapping( // Como não estou passando um parâmetro ele irá para o default,
            //que será o findAll, se eu passar um parâmetro ele irá para o findById (SE FOR UM GET).
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll (){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE
    )//O produces garante que o retorno será em formato JSON.
    public Person findById (@PathVariable("id") Long id){
       return service.findById(id);
    }

    @RequestMapping(
    method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE, //Consome uma aplicação JSON.
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create (@RequestBody//Irá pegar o valores passador no Person
                              Person person){
       return service.create(person);
    }

 @RequestMapping(
    method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE, //Consome uma aplicação JSON.
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update (@RequestBody
                              Person person){
       return service.update(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete (@PathVariable("id") Long id){
        service.delete(id);
    }
}
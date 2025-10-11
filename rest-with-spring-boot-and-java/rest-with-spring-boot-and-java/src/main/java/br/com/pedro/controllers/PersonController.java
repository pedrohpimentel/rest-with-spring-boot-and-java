package br.com.pedro.controllers;

import br.com.pedro.PersonServices;
import br.com.pedro.service.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController//Marca a classe como um Controlador Rest
@RequestMapping("/person")
public class PersonController {

    @Autowired //Injeção de dependência do Spring
    private PersonServices service;

    @RequestMapping(value = "/{id}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)//O produces garante que o retorno será em formato JSON.
    public Person findById (@PathVariable("id") String id){
       return service.findById(id);
    }
}

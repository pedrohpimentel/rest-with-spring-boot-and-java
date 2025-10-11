package br.com.pedro;

import br.com.pedro.service.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // Classe de serviço, sendo assim mais fácil de ser injetada em outras classes.
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());//Usado para registrar informações (logs).

    public Person findById(String Id){
        logger.info("Finding one Person!"); //Registra uma mensagem no log do sistema.

        Person person = new Person();
        person.setId(counter.incrementAndGet()); //Incrementa o contador e define como o (id) da pessoas.
        person.setFirstName("Pedro");
        person.setLastName("Henrique");
        person.setAddress("Monte Sião - MINAS GERAIS - BRASIL");
        person.setGender("Male");
        return person;
    }

}

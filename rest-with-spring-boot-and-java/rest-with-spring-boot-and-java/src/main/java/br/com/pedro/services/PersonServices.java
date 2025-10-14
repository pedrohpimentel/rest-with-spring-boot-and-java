package br.com.pedro.services;

import br.com.pedro.services.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // Classe de serviço, sendo assim mais fácil de ser injetada em outras classes.
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());//Usado para registrar informações (logs).

    public List<Person> findAll(){
        logger.info("Finding all People!");
       List <Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson (i);
            persons.add(person);
        }
        return persons;
    }

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

    public Person create(Person person){
        logger.info("Creating one Person!");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one Person!");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Set Adress in Brasil");
        person.setGender("Male");
        return person;
    }


}

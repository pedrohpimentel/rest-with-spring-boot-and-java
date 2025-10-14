package br.com.pedro.services;

import br.com.pedro.exception.ResourceNotFoundException;
import br.com.pedro.repository.PersonRepository;
import br.com.pedro.services.model.Person;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // Classe de serviço, sendo assim mais fácil de ser injetada em outras classes.
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private static final Logger logger = Logger.getLogger(PersonServices.class.getName());;//Usado para registrar informações (logs).

    private final PersonRepository repository;

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll(){
        logger.info("Finding all People!");
        repository.findAll();
        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person!"); //Registra uma mensagem no log do sistema.
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person){
        logger.info("Creating one Person!");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one Person!");
            Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");
       Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
       repository.delete(entity);
    }


}

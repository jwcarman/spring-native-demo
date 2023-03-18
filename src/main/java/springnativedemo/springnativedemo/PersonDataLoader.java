package springnativedemo.springnativedemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonDataLoader implements ApplicationRunner {

// ------------------------------ FIELDS ------------------------------

    private final PersonRepository repository;

// --------------------------- CONSTRUCTORS ---------------------------

    public PersonDataLoader(PersonRepository repository) {
        this.repository = repository;
    }

// ------------------------ INTERFACE METHODS ------------------------

// --------------------- Interface ApplicationRunner ---------------------

    @Override
    public void run(ApplicationArguments args) {
        Person person = new Person("12345");
        person.setFirstName("Spring");
        person.setLastName("Native");
        repository.save(person);
    }

}

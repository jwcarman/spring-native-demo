package springnativedemo.springnativedemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonDataLoader implements ApplicationRunner {

    private final PersonRepository repository;

    public PersonDataLoader(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Person person = new Person("12345");
        person.setFirstName("Spring");
        person.setLastName("Native");
        repository.save(person);
    }
}

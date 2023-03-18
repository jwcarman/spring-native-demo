package springnativedemo.springnativedemo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/persons")
@RestController
public class PersonController {

// ------------------------------ FIELDS ------------------------------

    private final PersonRepository repository;

// --------------------------- CONSTRUCTORS ---------------------------

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

// -------------------------- OTHER METHODS --------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody @NotNull @Valid CreatePersonRequest request) {
        Person person = new Person();
        person.setFirstName(request.firstName);
        person.setLastName(request.lastName);
        repository.save(person);
        return person;
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") String id) {
        return findPerson(id);
    }

    private Person findPerson(String id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") String id, @RequestBody @NotNull @Valid UpdatePersonRequest request) {
        Person person = findPerson(id);
        person.setFirstName(request.firstName);
        person.setLastName(request.lastName);
        repository.save(person);
        return person;
    }

// -------------------------- INNER CLASSES --------------------------

    public record CreatePersonRequest(@NotEmpty String firstName, @NotEmpty String lastName) {

    }

    public record UpdatePersonRequest(@NotEmpty String firstName, @NotEmpty String lastName) {

    }

}

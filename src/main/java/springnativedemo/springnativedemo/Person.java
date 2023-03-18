package springnativedemo.springnativedemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Person {

// ------------------------------ FIELDS ------------------------------

    @Id
    private String id;
    private String firstName;
    private String lastName;

// --------------------------- CONSTRUCTORS ---------------------------

    public Person() {
        this.id = UUID.randomUUID().toString();
    }

    public Person(String id) {
        this.id = id;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

// ------------------------ CANONICAL METHODS ------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

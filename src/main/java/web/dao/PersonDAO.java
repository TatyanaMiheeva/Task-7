package web.dao;

import web.model.Person;

import java.util.List;

public interface PersonDAO {
//    void saveUser(String name, String lastName, byte age);
    void savePerson(Person person);

    List<Person> getAllPersons();

    Person getPersonById(Long id);

    void update(Long id, Person person);

    void delete(Long id);
}

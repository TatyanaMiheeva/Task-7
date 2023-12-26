package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class PersonDAOImp implements PersonDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    public PersonDAOImp(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Transactional
    @Override
    public void savePerson(Person person) {
        entityManager.persist(person);
    }

//   @Transactional
    @Override
    public List<Person> getAllPersons() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    public Person getPersonById(Long id) {
        return entityManager.find(Person.class, id);
    }


    @Transactional
    @Override
    public void update(Long id, Person person) {
        Person personForUpdate = entityManager.find(Person.class, id);
        personForUpdate.setName(person.getName());
        personForUpdate.setLastname(person.getLastname());
        personForUpdate.setAge(person.getAge());
        entityManager.merge(personForUpdate);
//        Person upUser = getPersonById(id);
//        upUser.setName(upUser.getName());
//        upUser.setLastname(upUser.getLastname());
//        upUser.setAge(upUser.getAge());
//        entityManager.merge(upUser);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
//        entityManager.createQuery("delete from Person p where p.id=:id")
//                .setParameter("id", id)
//                .executeUpdate();
    }

}

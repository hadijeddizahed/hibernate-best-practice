package hibernatetutorial.org.sample.newFeatures;

import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Service
@Transactional
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public Person findBy(Long id) {
        return entityManager.find(Person.class,id);
    }

    @Override
    public Stream<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> getMultipleById(List<Long> ids) {
        MultiIdentifierLoadAccess<Person> multi = entityManager
                .unwrap(Session.class)
                .byMultipleIds(Person.class);
        List<Person> personList = multi.multiLoad(ids);
        return personList;
    }

    @Override
    public List<Person> findByName(String name) {
        Query query = entityManager.unwrap(Session.class).createQuery("Person.findByname")
                .setParameter("name", name);
        return query.getResultList();
    }



    <T> Consumer<T> combine(Collection<? extends Consumer<? super T>> consumers) {
        Consumer<T> result = noOpConsumer();
        for (Consumer<? super T> consumer : consumers) {
            result = result.andThen(consumer);
        }
        return result;
    }
    <T> Consumer<T> noOpConsumer() {
        return value -> { /* do nothing */ };
    }
}

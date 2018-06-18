package hibernatetutorial.org.sample.newFeatures;

import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
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
}

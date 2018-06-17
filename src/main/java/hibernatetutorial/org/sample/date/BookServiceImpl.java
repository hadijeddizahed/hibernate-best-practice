package hibernatetutorial.org.sample.date;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }
}
